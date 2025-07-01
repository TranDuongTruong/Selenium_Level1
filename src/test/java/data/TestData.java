package data;
import com.Railway.constant.Constants;
import com.Railway.driver.DriverManager;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TestData  {

    @BeforeMethod
    public void beforeTest(ITestContext iTestResult) {

        getData(iTestResult);

    }
    @DataProvider(name = "jsonDataProvider")
    public Object[][] getData(ITestContext context) {
        // Lấy tên class đang chạy
        String testClassName = context.getCurrentXmlTest().getClasses().get(0).getName();
        String simpleName = testClassName.substring(testClassName.lastIndexOf(".") + 1);

        // Load JSON file
        ObjectMapper mapper = new ObjectMapper();
        InputStream is = getClass().getClassLoader().getResourceAsStream("data.json");
        JsonNode root = null;
        try {
            root = mapper.readTree(is);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        JsonNode node = root.get(simpleName);
        if (node == null) {
            throw new RuntimeException("No data found for test class: " + simpleName);
        }

        List<Object[]> dataList = new ArrayList<>();

        if (node.isArray()) {
            for (JsonNode item : node) {
                Map<String, Object> map = mapper.convertValue(item, Map.class);
                dataList.add(new Object[]{map});
            }
        } else if (node.isObject()) {
            Map<String, Object> map = mapper.convertValue(node, Map.class);
            dataList.add(new Object[]{map});
        }

        return dataList.toArray(new Object[0][]);
    }

}

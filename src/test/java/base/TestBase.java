package base;

import com.Railway.constant.Constants;
import com.Railway.driver.DriverManager;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import listener.TestListener;
import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Listeners(TestListener.class)
public class TestBase  {

    protected SoftAssert softAssert;
    protected Logger logger ;

    @BeforeMethod
    public void beforeTest(ITestContext iTestContext){

        DriverManager.createDriver();
        DriverManager.get_driver().get(Constants.BASE_URL);
        softAssert = new SoftAssert();

    }

    @AfterMethod
    public void afterTest(){
        softAssert.assertAll();
        DriverManager.quitDriver();



    }
    @BeforeSuite
    public void copyEnvToAllure() throws IOException {
        Path source = Paths.get("src/main/resources/environment.properties");
        Path destination = Paths.get("target/allure-results/environment.properties");
        Files.createDirectories(destination.getParent());
        Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
    }

    @DataProvider(name = "jsonDataProvider")
    public Object[][] getData(Method method) {
        String simpleName =  method.getDeclaringClass().getSimpleName();

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
        } else {
            throw new RuntimeException("Do not support data type: "+node.getNodeType());
        }

        return dataList.toArray(new Object[0][]);
    }



}

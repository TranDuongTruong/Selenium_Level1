package base;

import com.Railway.constant.Constants;
import com.Railway.driver.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

public class TestBase {

    protected SoftAssert softAssert;
    @BeforeMethod
    public void beforeTest(){
        DriverManager.createDriver();
        DriverManager.get_driver().get(Constants.BASE_URL);
        softAssert = new SoftAssert();

    }

    @AfterMethod
    public void afterTest(){

        DriverManager.quitDriver();
        softAssert.assertAll();

    }




}

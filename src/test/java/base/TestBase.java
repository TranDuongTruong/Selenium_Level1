package base;

import constant.Constants;
import driver.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    @BeforeMethod
    public void beforeTest(){
        DriverManager.createDriver();
        DriverManager.get_driver().get(Constants.BASE_URL);
    }

    @AfterMethod
    public void afterTest(){
        DriverManager.quitDriver();
    }




}

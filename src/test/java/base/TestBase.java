package base;

import com.Railway.constant.Constants;
import com.Railway.driver.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

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
    @BeforeSuite
    public void copyEnvToAllure() throws IOException {
        Path source = Paths.get("src/main/resources/environment.properties");
        Path destination = Paths.get("target/allure-results/environment.properties");
        Files.createDirectories(destination.getParent());
        Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
    }





}

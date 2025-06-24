package book_ticket;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.BasePage;
import pages.LoginPage;

public class TC04 extends TestBase {

    @Test
    public void testCaseTC01(){
        SoftAssert softAssert = new SoftAssert();
        BasePage.goToSpecificPage("Book ticket");
        LoginPage loginPage=new LoginPage();
        softAssert.assertTrue(loginPage.pageIsExist(),"Check Login page exist");
        softAssert.assertAll();

    }


}

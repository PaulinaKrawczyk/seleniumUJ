package selenium.test.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.test.automation.pages.DashboardPage;
import selenium.test.automation.pages.LoginPage;

public class LoginTest extends DefaultTest {

    @Test
    public void successLoginTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillLoginForm("administrator@testarena.pl", "sumXQQ72$L");
        loginPage.submitLoginForm();

        DashboardPage dashboardPage = new DashboardPage(driver);
//        screenshot.make(driver, "successLogin");
        Assert.assertTrue(dashboardPage.isLogoutButtonDisplayed());
    }
}
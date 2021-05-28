package selenium.test.automation.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import selenium.test.automation.utils.drivers.DriverFactory;
import selenium.test.automation.utils.types.BrowserType;

public abstract class DefaultTest {

    protected static WebDriver driver;

    @BeforeTest
    public void setUpTest() {
        driver = new DriverFactory().getDriver(BrowserType.CHROME);

        driver.get("http://beta.demo.testarena.pl/login");
    }

    @AfterTest
    public void tearDownTest() {
        driver.quit();
    }
}
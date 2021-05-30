package selenium.test.automation.tests;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import selenium.test.automation.utils.drivers.DriverFactory;
import selenium.test.automation.utils.generators.BaseGenerator;
import selenium.test.automation.utils.logger.CustomLogger;
import selenium.test.automation.utils.screen.CustomScreenshot;
import selenium.test.automation.utils.types.BrowserType;

import java.lang.reflect.Method;

public abstract class DefaultTest {

    protected static WebDriver driver;
    protected static CustomScreenshot screenshot;
    protected static BaseGenerator baseGenerator;
    protected static CustomLogger logger;

    @BeforeTest
    @Parameters({"browser"})
    public void setUpTest(String browserType) {
        screenshot = new CustomScreenshot();
        baseGenerator = new BaseGenerator();
        logger = new CustomLogger();
        driver = new DriverFactory().getDriver(BrowserType.valueOf(browserType));

        driver.get("http://beta.demo.testarena.pl/login");
    }

    @BeforeMethod
    public void setUpMethod(Method method) {
        logger.info("Test '" + method.getName() + "' has started");
    }

    @AfterMethod
    @Parameters({"makeScreenshot"})
    public void tearDownMethod(ITestResult result, String makeScreenshot) {
        if (makeScreenshot.equalsIgnoreCase("ON_FAIL")) {
            if (result.getStatus() == ITestResult.FAILURE)
                screenshot.make(driver, result.getMethod().getMethodName() + "_FAILURE");
        } else if (makeScreenshot.equalsIgnoreCase("ALWAYS")) {
            screenshot.make(driver, result.getMethod().getMethodName());
        }

        if (result.getStatus() == ITestResult.FAILURE) {
            logger.error("Test '" + result.getMethod().getMethodName() + "' has finished with status: FAILURE");
        } else if (result.getStatus() == ITestResult.SKIP) {
            logger.info("Test '" + result.getMethod().getMethodName() + "' has finished with status: SKIP");
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            logger.info("Test '" + result.getMethod().getMethodName() + "' has finished with status: SUCCESS");
        }
    }

    @AfterTest
    public void tearDownTest() {
        driver.quit();
    }
}
package selenium.test.automation.tests;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import selenium.test.automation.utils.BaseConfiguration;
import selenium.test.automation.utils.drivers.DriverFactory;
import selenium.test.automation.utils.generators.BaseGenerator;
import selenium.test.automation.utils.logger.CustomLogger;
import selenium.test.automation.utils.screen.CustomScreenshot;
import selenium.test.automation.utils.types.BrowserType;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class DefaultTest {

    protected static WebDriver driver;
    protected static CustomScreenshot screenshot;
    protected static BaseGenerator baseGenerator;
    protected static CustomLogger logger;
    protected static ExtentReports extentReports;
    protected static ExtentTest extentTest;

    @BeforeTest
    @Parameters({"browser"})
    public void setUpTest(String browserType) {
        extentReports = new ExtentReports(BaseConfiguration.REPORT_PATH + new Date().getTime() + "/" + "report.html", true);

        extentReports.addSystemInfo("Executor:", "Paulina");
        extentReports.addSystemInfo("Date", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        extentReports.addSystemInfo("Browser", browserType);
        screenshot = new CustomScreenshot();
        baseGenerator = new BaseGenerator();
        logger = new CustomLogger();
        driver = new DriverFactory().getDriver(BrowserType.valueOf(browserType));
        driver.get("http://beta.demo.testarena.pl/login");
    }

    @BeforeMethod
    public void setUpMethod(Method method) {
        logger.info("Test '" + method.getName() + "' has started");
        extentTest = extentReports.startTest(method.getName());
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
            extentTest.log(LogStatus.FAIL, result.getMethod().getMethodName());
        } else if (result.getStatus() == ITestResult.SKIP) {
            logger.info("Test '" + result.getMethod().getMethodName() + "' has finished with status: SKIP");
            extentTest.log(LogStatus.SKIP, result.getMethod().getMethodName());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            logger.info("Test '" + result.getMethod().getMethodName() + "' has finished with status: SUCCESS");
            extentTest.log(LogStatus.PASS, result.getMethod().getMethodName());
        }

        extentReports.endTest(extentTest);
    }

    @AfterTest
    public void tearDownTest() {
        driver.quit();
        extentReports.flush();
        extentReports.close();
    }
}
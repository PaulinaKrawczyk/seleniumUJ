package selenium.test.automation.utils.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import selenium.test.automation.utils.files.FileHelper;
import selenium.test.automation.utils.types.BrowserType;

import java.util.concurrent.TimeUnit;

public class DriverFactory {

    public WebDriver getDriver(BrowserType browserType) {
        if (browserType == BrowserType.CHROME) {
            System.setProperty("webdriver.chrome.driver", new FileHelper().getResourceFilePath("chromedriver.exe"));
            WebDriver driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            return driver;
        } else if (browserType == BrowserType.FIREFOX) {
            System.out.println("Firefox driver not configured!");
        }
        return null;
    }
}
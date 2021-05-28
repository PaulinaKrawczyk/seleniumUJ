package selenium.test.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FirstTest {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\pauli\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://google.pl");
    }

    @Test
    public void firstTestMethod() {
        Assert.assertEquals("Google", driver.getTitle());
        driver.findElement(By.id("L2AGLb")).click();
    }

    @Test
    public void secondTestMethod() {
        driver.findElement(By.name("q")).sendKeys("testerzy.pl");
        driver.findElement(By.cssSelector("body > div.L3eUgb > div.o3j99.ikrT4e.om7nvf > form > div:nth-child(1) > div.A8SBwf > div.FPdoLc.lJ9FBc > center > input.RNmpXc")).click();
//        driver.findElement(By.xpath("//html/body/div[1]/div[3]/form/div[1]/div[1]/div[3]/center/input[2]")).click();
        Assert.assertEquals("testerzy.pl - Lepsza jakość testowania", driver.getTitle());
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}

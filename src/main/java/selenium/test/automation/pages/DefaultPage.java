package selenium.test.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public abstract class DefaultPage {

    protected WebDriver driver;

    public DefaultPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    protected void fillElement(WebElement element, String value) {
        element.clear();
        element.sendKeys(value);
    }

    protected void clickElement(WebElement element) {
        element.click();
    }

    protected boolean isElementDisplayed(WebElement element) {
        return element.isDisplayed();
    }

}

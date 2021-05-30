package selenium.test.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EnvironmentListPage extends DefaultPage {
    public EnvironmentListPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//html/body/div[1]/section/article/div[1]/nav/ul/li/a")
    public WebElement addEnvironmentPageLink;

    @FindBy(id = "j_info_box")
    public WebElement infoBox;


    public void goToAddEnvironmentPage() {
        clickElement(addEnvironmentPageLink);
    }

    public boolean isInfoBoxDisplayed() {
        return isElementDisplayed(infoBox);
    }
}
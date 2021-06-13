package selenium.test.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TagListPage extends DefaultPage {
    public TagListPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "/html/body/div[1]/section/article/div[1]/nav/ul/li/a")
    public WebElement addTagPageLink;

    @FindBy(id = "j_info_box")
    public WebElement infoBox;


    public void goToAddTagPage() {
        clickElement(addTagPageLink);
    }

    public boolean isInfoBoxDisplayed() {
        return isElementDisplayed(infoBox);
    }
}

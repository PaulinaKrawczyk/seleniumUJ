package selenium.test.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VersionListPage extends DefaultPage {
    public VersionListPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css ="#content > article > div.content_header > nav > ul > li > a")
    public WebElement addVersionPageLink;

    @FindBy(id = "j_info_box")
    public WebElement infoBox;

    public void goToAddVersionPage() {
        clickElement(addVersionPageLink);
    }

    public boolean isInfoBoxDisplayed() {
        return isElementDisplayed(infoBox);
    }

}

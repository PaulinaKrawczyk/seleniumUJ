package selenium.test.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddVersionPage extends DefaultPage {
    public AddVersionPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "name")
    private WebElement nameFiled;

    @FindBy(id = "description")
    private WebElement descriptionField;

    @FindBy(id = "save")
    private WebElement saveButton;


    public void fillAddVersionForm(String name, String description) {
        fillElement(nameFiled, name);
        fillElement(descriptionField, description);
    }

    public void submitAddVersionForm() {
        clickElement(saveButton);
    }
}

package selenium.test.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddEnvironmentPage extends DefaultPage {

    @FindBy(id = "name")
    private WebElement nameFiled;

    @FindBy(id = "description")
    private WebElement descriptionField;

    @FindBy(id = "save")
    private WebElement saveButton;

    public AddEnvironmentPage(WebDriver driver) {
        super(driver);
    }

    public void fillAddEnvironmentForm(String name, String description) {
        fillElement(nameFiled, name);
        fillElement(descriptionField, description);
    }

    public void submitAddEnvironmentForm() {
        clickElement(saveButton);
    }
}
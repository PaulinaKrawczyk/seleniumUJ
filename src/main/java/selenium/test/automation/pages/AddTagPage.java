package selenium.test.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddTagPage extends DefaultPage{

        @FindBy(id = "name")
        private WebElement nameFiled;

        @FindBy(id = "save")
        private WebElement saveButton;

        public AddTagPage(WebDriver driver) {
            super(driver);
        }

        public void fillAddTagForm(String name) {
            fillElement(nameFiled, name);
        }

        public void submitAddEnvironmentForm() {
            clickElement(saveButton);
        }
}

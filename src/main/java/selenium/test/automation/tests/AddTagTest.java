package selenium.test.automation.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import selenium.test.automation.pages.AddTagPage;
import selenium.test.automation.pages.DashboardPage;
import selenium.test.automation.pages.TagListPage;
import selenium.test.automation.utils.generators.TagDataGenerator;

public class AddTagTest extends DefaultTest {
    @BeforeClass
    public void setUpClass() {
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.goToTagListPage();
    }

    @Test(dataProvider = "generatedTagDataProvider")
    public void successAddTagTest(String name) {
        TagListPage tagListPage = new TagListPage(driver);
        tagListPage.goToAddTagPage();
        AddTagPage addTagPage = new AddTagPage(driver);
        addTagPage.fillAddTagForm(name);
//        addTagPage.fillAddTagForm(new Date().getTime() + "_tag", baseGenerator.generateString(255));
        addTagPage.submitAddEnvironmentForm();
        tagListPage = new TagListPage(driver);
        Assert.assertTrue(tagListPage.isInfoBoxDisplayed());
    }

    @DataProvider(name = "generatedTagDataProvider")
    public Object[][] generatedTagDataProvider() {
        return new TagDataGenerator().generateTagData();
    }
}

package selenium.test.automation.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.test.automation.pages.AddTagPage;
import selenium.test.automation.pages.DashboardPage;
import selenium.test.automation.pages.TagListPage;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

import java.util.Date;

public class AddTagTest extends DefaultTest {
    @Test
    public void successAddTagTest() {
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.goToTagListPage();

        TagListPage tagListPage = new TagListPage(driver);
        tagListPage.goToAddTagPage();

        AddTagPage addTagPage = new AddTagPage(driver);
//        $(By.xpath("//*[@id=\"content\"]/article/nav/ul/li/a")).click();
//        $(By.name("name")).setValue("tag");
        addTagPage.fillAddTagForm(new Date().getTime() + "_tag", baseGenerator.generateString(255));
        addTagPage.submitAddEnvironmentForm();

        tagListPage = new TagListPage(driver);
        Assert.assertTrue(tagListPage.isInfoBoxDisplayed());
    }
}

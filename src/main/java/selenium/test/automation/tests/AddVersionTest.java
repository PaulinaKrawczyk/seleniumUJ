package selenium.test.automation.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import selenium.test.automation.pages.AddVersionPage;
import selenium.test.automation.pages.DashboardPage;
import selenium.test.automation.pages.VersionListPage;
import selenium.test.automation.utils.generators.VersionDataGenerator;

public class AddVersionTest extends DefaultTest {
    @BeforeClass
    public void setUpClass() {
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.goToVersionListPage();
    }

    @Test(dataProvider = "versionDataProvider")
    public void successAddVersionTest(String name, String description) {
//        DashboardPage dashboardPage = new DashboardPage(driver);
//        dashboardPage.goToVersionListPage();

        VersionListPage versionListPage = new VersionListPage(driver);
        versionListPage.goToAddVersionPage();

        AddVersionPage addVersionPage = new AddVersionPage(driver);
        addVersionPage.fillAddVersionForm(name, description);
        addVersionPage.submitAddVersionForm();

        versionListPage = new VersionListPage(driver);
        Assert.assertTrue(versionListPage.isInfoBoxDisplayed());
    }


    @DataProvider(name = "versionDataProvider")
    public Object[][] versionDataProvider() {
        return new VersionDataGenerator().generateVersionData();
    }
}


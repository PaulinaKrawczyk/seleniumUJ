package selenium.test.automation.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import selenium.test.automation.pages.AddVersionPage;
import selenium.test.automation.pages.DashboardPage;
import selenium.test.automation.pages.VersionListPage;
import selenium.test.automation.utils.data.DataReader;
import selenium.test.automation.utils.generators.VersionDataGenerator;

public class AddVersionTest extends DefaultTest {

    @BeforeClass
    public void setUpClass() {
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.goToVersionListPage();
    }

    @Test(dataProvider = "generatedVersionDataProvider")
    public void successAddVersionTest(String name, String description) {
        VersionListPage versionListPage = new VersionListPage(driver);
        versionListPage.goToAddVersionPage();

        AddVersionPage addVersionPage = new AddVersionPage(driver);
        addVersionPage.fillAddVersionForm(name, description);
        addVersionPage.submitAddVersionForm();

        versionListPage = new VersionListPage(driver);
        Assert.assertTrue(versionListPage.isInfoBoxDisplayed());
    }

    @DataProvider(name = "generatedVersionDataProvider")
    public Object[][] generatedVersionDataProvider() {
        return new VersionDataGenerator().generateVersionData();
    }

    @DataProvider(name = "readFromCSVVersionDataProvider")
    public Object[][] readFromCSVVersionDataProvider() {
        return new DataReader().readVersionData("versionData.csv");
    }
}
package reportportal.tests.ui;

import com.epam.jira.JIRATestKey;
import com.epam.reportportal.product.buisness.objects.credentials.CredentialsFactory;
import com.epam.reportportal.product.buisness.objects.dashboard.Dashboard;
import com.epam.reportportal.product.buisness.objects.dashboard.DashboardFactory;
import com.epam.reportportal.product.buisness.objects.filter.Filter;
import com.epam.reportportal.product.buisness.objects.filter.FilterFactory;
import com.epam.reportportal.product.pages.AllDashboardsPage;
import com.epam.reportportal.product.services.AuthenticationService;
import com.epam.reportportal.product.services.NavigationService;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest{
    @BeforeMethod(description = "logs in report portal with default credentials")
    public void loginToReportPortal() {
        new NavigationService().navigateToLoginPage();
        new AuthenticationService().login(
                CredentialsFactory.withDataFromProperty().getLogin(),
                CredentialsFactory.withDataFromProperty().getPassword());
    }
    @JIRATestKey(key="EPMFARMATS-16809")
    @Test
    public void addNewDashboard() {
        Dashboard dashboard = DashboardFactory.withRandomTestData();
        boolean isDashboardAdded = new AllDashboardsPage().open()
                .addNewDashboard(dashboard.getName(), dashboard.getDescription())
                .isDashboardAdded();
        Assert.assertTrue(isDashboardAdded);
    }
    @JIRATestKey(key="EPMFARMATS-16810")
    @Test
    public void testNameOfCreatedDashboard() {
        Dashboard dashboard = DashboardFactory.withRandomTestData();
        boolean isNameMatchesToCreatedOne = new AllDashboardsPage().open()
                .addNewDashboard(dashboard.getName(), dashboard.getDescription())
                .returnToAllDashboardsPage()
                .isNameOfCreatedDashboardCorrect(dashboard.getName());
        Assert.assertTrue(isNameMatchesToCreatedOne);
    }
    @JIRATestKey(key="EPMFARMATS-16812")
    @Test
    public void testDescriptionOfCreatedDashboard() {
        Dashboard dashboard = DashboardFactory.withRandomTestData();
        boolean isDescriptionMatchesToCreatedOne = new AllDashboardsPage().open()
                .addNewDashboard(dashboard.getName(), dashboard.getDescription())
                .returnToAllDashboardsPage()
                .isDescriptionOfCreatedDashboardCorrect(dashboard.getDescription());
        Assert.assertTrue(isDescriptionMatchesToCreatedOne);
    }
    @Test
    public void testSearchByNameInput(){
        Dashboard searchedDashboard = DashboardFactory.withRandomTestData();
        boolean isDashboardFound = new AllDashboardsPage().open()
                .addNewDashboard(searchedDashboard.getName(), searchedDashboard.getDescription())
                .returnToAllDashboardsPage()
                .addSeveralDashboards(3)
                .typeDashboardNameIntoSearchByNameInput(searchedDashboard.getName())
                .isDashboardFoundWithSearchByNameInput(searchedDashboard.getName());
        Assert.assertTrue(isDashboardFound);
    }
    @Test
    public void editDashboard(){
        Dashboard dashboard = DashboardFactory.withRandomTestData();
        Dashboard newDashboard = DashboardFactory.withRandomTestData();
        boolean isDashboardChanged = new AllDashboardsPage().open()
                .addNewDashboard(dashboard.getName(), dashboard.getDescription())
                .returnToAllDashboardsPage()
                .editDashboard(dashboard.getName(),newDashboard.getName())
                .isNameOfCreatedDashboardCorrect(newDashboard.getName());
        Assert.assertTrue(isDashboardChanged);
    }
    @JIRATestKey(key="EPMFARMATS-16811")
    @Test
    public void deleteDashboard(){
        Dashboard dashboard = DashboardFactory.withRandomTestData();
        boolean isDashboardDeleted = new AllDashboardsPage().open()
                .addNewDashboard(dashboard.getName(), dashboard.getDescription())
                .returnToAllDashboardsPage()
                .deleteDashboard(dashboard.getName())
                .isDashboardDeleted(dashboard.getName());
        Assert.assertTrue(isDashboardDeleted);
    }
    @Test
    public void addWidget(){
        Dashboard dashboard = DashboardFactory.withRandomTestData();
        Filter filter = FilterFactory.withRandomTestData();
        boolean isNewWidgetAdded = new AllDashboardsPage().open()
                .addNewDashboard(dashboard.getName(), dashboard.getDescription())
                .addNewWidget(filter.getFilterName(), filter.getLaunchName())
                .isNewWidgetAdded(filter.getFilterName());
        Assert.assertTrue(isNewWidgetAdded);
    }
}

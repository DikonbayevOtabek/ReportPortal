package reportportal.tests.stepdefs;

import com.epam.reportportal.product.buisness.objects.dashboard.Dashboard;
import com.epam.reportportal.product.buisness.objects.dashboard.DashboardFactory;
import com.epam.reportportal.product.buisness.objects.filter.Filter;
import com.epam.reportportal.product.buisness.objects.filter.FilterFactory;
import com.epam.reportportal.product.pages.AllDashboardsPage;
import com.epam.reportportal.product.pages.DashboardPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.testng.Assert.assertTrue;

public class DashboardSteps {
    private Dashboard dashboard;
    private Dashboard newDashboard;
    private Filter filter = FilterFactory.withRandomTestData();

    @When("^User opens ALL DASHBOARDS page$")
    public void openAllDashboardsPage() {
        new AllDashboardsPage().open();
    }

    @When("^User adds a new dashboard with random test data$")
    public void addNewDashboard() {
        dashboard = DashboardFactory.withRandomTestData();
        new AllDashboardsPage().addNewDashboard(dashboard.getName(), dashboard.getDescription());
    }

    @When("User adds a few more dashboards with random data")
    public void addFewMoreDashboardsWithRandomData() {
        new AllDashboardsPage().addSeveralDashboards(3);
    }

    @When("User enters the name of the first dashboard with Search by name input")
    public void enterNameOfFirstDashboardWithSearchByNameInput() {
        new AllDashboardsPage().typeDashboardNameIntoSearchByNameInput(dashboard.getName());
    }

    @When("User replaces the dashboard name with new one")
    public void replacesDashboardName() {
        newDashboard = DashboardFactory.withRandomTestData();
        new AllDashboardsPage().editDashboard(dashboard.getName(), newDashboard.getName());
    }

    @When("User deletes dashboard")
    public void deletesDashboard() {
        new AllDashboardsPage().deleteDashboard(dashboard.getName());
    }

    @When("User adds widget with random data")
    public void addNewWidget() {
        new DashboardPage().addNewWidget(filter.getFilterName(), filter.getLaunchName());
    }

    @When("User goes to ALL DASHBOARDS page")
    public void returnToAllDashboardsPage() {
        new DashboardPage().returnToAllDashboardsPage();
    }

    @Then("^User sees Add new widget button on the page$")
    public void dashboardAdded() {
        assertTrue(new DashboardPage().isDashboardAdded());
    }

    @Then("^User sees the correct name of added dashboard on the ALL DASHBOARDS page$")
    public void nameOfCreatedDashboardCorrect() {
        boolean isNameMatchesToCreatedOne = new AllDashboardsPage()
                .isNameOfCreatedDashboardCorrect(dashboard.getName());
        assertTrue(isNameMatchesToCreatedOne);
    }

    @Then("^User sees the correct description of added dashboard on the ALL DASHBOARDS page$")
    public void descriptionOfCreatedDashboardCorrect() {
        boolean isDescriptionMatchesToCreatedOne = new AllDashboardsPage()
                .isDescriptionOfCreatedDashboardCorrect(dashboard.getDescription());
        assertTrue(isDescriptionMatchesToCreatedOne);
    }


    @Then("User sees only first dashboard's name in the list")
    public void dashboardFoundWithSearchByNameInput() {
        boolean isDashboardFound = new AllDashboardsPage().isDashboardFoundWithSearchByNameInput(dashboard.getName());
        assertTrue(isDashboardFound);
    }


    @Then("User sees a new name on the ALL DASHBOARDS page")
    public void dashboardNameReplaced() {
        assertTrue(new AllDashboardsPage().isNameOfCreatedDashboardCorrect(dashboard.getName()));
    }

    @Then("User sees a modified name on the ALL DASHBOARDS page")
    public void newDashboardNameReplaced() {
        assertTrue(new AllDashboardsPage().isNameOfCreatedDashboardCorrect(newDashboard.getName()));
    }


    @Then("User does not see the dashboard name on the ALL DASHBOARDS page")
    public void dashboardDeleted() {
        assertTrue(new AllDashboardsPage().isDashboardDeleted(dashboard.getName()));
    }

    @Then("User sees the name of new widget on dashboard page")
    public void newWidgetAdded() {
        assertTrue(new DashboardPage().isNewWidgetAdded(filter.getFilterName()));
    }
}

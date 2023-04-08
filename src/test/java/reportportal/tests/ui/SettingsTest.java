package reportportal.tests.ui;

import com.epam.jira.JIRATestKey;
import com.epam.reportportal.product.buisness.objects.credentials.CredentialsFactory;
import com.epam.reportportal.product.buisness.objects.settings.defecttypes.ProductBugFactory;
import com.epam.reportportal.product.buisness.objects.settings.general.GeneralSettingsConfigFactory;
import com.epam.reportportal.product.pages.DefectTypesPage;
import com.epam.reportportal.product.pages.PatternAnalysisPage;
import com.epam.reportportal.product.pages.ProjectGeneralSettingsPage;
import com.epam.reportportal.product.services.AuthenticationService;
import com.epam.reportportal.product.services.NavigationService;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SettingsTest extends BaseTest {
    @BeforeMethod(description = "logs in report portal with default credentials")
    public void loginToReportPortal() {
        new NavigationService().navigateToLoginPage();
        new AuthenticationService().login(
                CredentialsFactory.withDataFromProperty().getLogin(),
                CredentialsFactory.withDataFromProperty().getPassword());
    }

    @JIRATestKey(key = "EPMFARMATS-16814")
    @Test(description = "opens general project settings and establish is project name field disabled to change")
    public void checkIfProjectNameFieldIsDisabled() {
        new ProjectGeneralSettingsPage()
                .open()
                .isNameFieldDisabled("disabled");
    }

    @JIRATestKey(key = "EPMFARMATS-16815")
    @Test(description = "opens general project settings and checks ability to change launch inactivity timeout")
    public void checkIfLaunchInactivityTimeoutCanBeSet() {
        new ProjectGeneralSettingsPage()
                .open()
                .setLaunchInactivityTimeout(GeneralSettingsConfigFactory.withLaunchInactivityTimeoutFromProperties())
                .pressSubmitButtonAndValidateSuccessfulChange();
    }

    @JIRATestKey(key = "EPMFARMATS-16816")
    @Test(description = "opens pattern analysis settings and creates new pattern with max name and tries to copy pattern")
    public void checkIfPatternCanBeCopiedWithMaxNameValue() {
        new ProjectGeneralSettingsPage()
                .open();
        new PatternAnalysisPage()
                .open()
                .createPatternWithMaxNameValue()
                .isCopyNotCreated();
    }

    @JIRATestKey(key = "EPMFARMATS-16817")
    @Test(description = "opens defect types tab and check if new custom product bug can be created")
    public void checkIfCustomProductBugsGroupCanBeCreated() {
        new ProjectGeneralSettingsPage()
                .open();
        String createdRandomName = new DefectTypesPage()
                .open()
                .createNewDefectType(
                        ProductBugFactory.withRandomTestData().getName(),
                        ProductBugFactory.withRandomTestData().getAbbreviation());
        new DefectTypesPage()
                .checkIfCreatedDefectTypeIsPresent(createdRandomName);

    }

}

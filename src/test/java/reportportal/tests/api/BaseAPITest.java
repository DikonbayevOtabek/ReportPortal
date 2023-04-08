package reportportal.tests.api;

import com.epam.reportportal.product.buisness.objects.credentials.Credentials;
import com.epam.reportportal.product.buisness.objects.credentials.CredentialsFactory;
import com.epam.reportportal.product.http.model.request.TokenRequestBody;
import com.epam.reportportal.product.http.service.AuthenticationService;


public class BaseAPITest {
    protected static final String ID = "id";
    private final Credentials defaultCredentials = CredentialsFactory.withDataFromProperty();
    private final TokenRequestBody tokenRequestBody = new TokenRequestBody(defaultCredentials.getLogin(), defaultCredentials.getPassword());
    protected String token = AuthenticationService.generateAccessToken(tokenRequestBody);



    private final Credentials adminCredentials = CredentialsFactory.withAdminDataFromProperty();
    private final TokenRequestBody adminTokenRequestBody = new TokenRequestBody(adminCredentials.getLogin(), adminCredentials.getPassword());
    protected String adminToken = AuthenticationService.generateAccessToken(adminTokenRequestBody);

}

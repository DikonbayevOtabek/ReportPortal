package com.epam.reportportal.product.buisness.objects.credentials;

import com.epam.reportportal.framework.configuration.PropertyDataReader;

public class CredentialsFactory {
    private static final String LOGIN_KEY_VALUE_FOR_PROPERTY = "report-portal.bo.credentials.login";
    private static final String PASSWORD_KEY_VALUE_FOR_PROPERTY = "report-portal.bo.credentials.password";
    private static final String ADMIN_LOGIN_KEY_VALUE_FOR_PROPERTY = "report-portal.bo.credentials.admin.login";
    private static final String ADMIN_PASSWORD_KEY_VALUE_FOR_PROPERTY = "report-portal.bo.credentials.admin.password";
    private static String login;
    private static String password;

    private CredentialsFactory() {
        throw new IllegalStateException("It is prohibited to create" + CredentialsFactory.class + "entity");
    }

    public static Credentials withAdminDataFromProperty() {
        login = PropertyDataReader.getDataByKey(ADMIN_LOGIN_KEY_VALUE_FOR_PROPERTY);
        password = PropertyDataReader.getDataByKey(ADMIN_PASSWORD_KEY_VALUE_FOR_PROPERTY);
        return new Credentials(login, password);
    }

    public static Credentials withDataFromProperty() {
        login = PropertyDataReader.getDataByKey(LOGIN_KEY_VALUE_FOR_PROPERTY);
        password = PropertyDataReader.getDataByKey(PASSWORD_KEY_VALUE_FOR_PROPERTY);
        return new Credentials(login, password);
    }
}

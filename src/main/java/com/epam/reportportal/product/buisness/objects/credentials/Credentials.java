package com.epam.reportportal.product.buisness.objects.credentials;

import com.epam.reportportal.utils.StringConstructor;


public class Credentials {
    private static  String login;
    private static  String password;
    private static final int LENGTH_OF_GENERATED_USERNAME = 6;
    private static final int LENGTH_OF_GENERATED_PASSWORD = 6;

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public Credentials(String login, String password) {
        Credentials.login = login;
        Credentials.password = password;
    }
    public static Credentials createUserWithIncorrectPassword() {
        return new Credentials(login, StringConstructor.generateRandomPassword(LENGTH_OF_GENERATED_PASSWORD));
    }

    public static Credentials createUserWithIncorrectUsername() {
        return new Credentials(StringConstructor.generateRandomUsername(LENGTH_OF_GENERATED_USERNAME), password);
    }

    public static Credentials createUserWithEmptyUsername() {
        return new Credentials("", StringConstructor.generateRandomPassword(LENGTH_OF_GENERATED_PASSWORD));
    }

    public static Credentials createUserWithEmptyPassword() {
        return new Credentials(StringConstructor.generateRandomUsername(LENGTH_OF_GENERATED_USERNAME), "");
    }
}

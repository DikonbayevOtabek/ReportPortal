package com.epam.reportportal.product.http.model.request;


import java.util.Objects;

public class TokenRequestBody {
    private String grantType ="password";
    private String username;
    private String password;

    public TokenRequestBody(String username, String password) {
        Objects.requireNonNull(password, "Key cannot be null");
        Objects.requireNonNull(username, "User name cannot be null");
        this.password = password;
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getGrantType() {
        return grantType;
    }
}

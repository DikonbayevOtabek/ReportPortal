package com.epam.reportportal.product.http.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"token_type", "refresh_token", "expires_in", "scope", "jti"})
public class TokenResponseBody {

    private String access_token;

    public String getAccess_token() {
        return access_token;
    }
}


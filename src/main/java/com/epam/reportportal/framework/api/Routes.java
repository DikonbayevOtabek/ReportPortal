package com.epam.reportportal.framework.api;


public class Routes {
    private Routes(){
        throw new IllegalStateException("It is prohibited to create instance of " + Routes.class);
    }
    public static final String BASE_URL = "http://localhost:8080/";
    public static final String GET_TOKEN = "uat/sso/oauth/token";
    public static final String CREATE_DASHBOARD = "api/v1/default_personal/dashboard";
    public static final String MODIFY_DASHBOARD = "api/v1/default_personal/dashboard/%s";
    public static final String GET_ALL_WIDGET_NAMES_WHICH_BELONG_TO_A_USER = "api/v1/default_personal/widget/names/all";
    public static final String CREATE_USER_FILTER = "api/v1/default_personal/filter";
    public static final String CREATE_A_NEW_WIDGET = "api/v1/default_personal/widget";
    public static final String GET_WIDGET_BY_ID = "api/v1/default_personal/widget/";
    public static final String USER_CONTROLLER = "api/v1/user";

}

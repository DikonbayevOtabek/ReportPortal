package com.epam.reportportal.product.http.model.request.user;

import com.epam.reportportal.utils.StringConstructor;

public class UserCreationRequestBodyCreator {

    private static final int LENGTH_OF_GENERATED_STRING = 7;
    private static final String LOGIN = StringConstructor.generateRandomUsername(LENGTH_OF_GENERATED_STRING);
    private static final String PASSWORD = StringConstructor.generateRandomPassword(LENGTH_OF_GENERATED_STRING);
    private static final String EMAIL = StringConstructor.generateRandomEmail(LENGTH_OF_GENERATED_STRING);

    private UserCreationRequestBodyCreator(){
        throw new IllegalStateException("It is prohibited to create instance of " + UserCreationRequestBodyCreator.class);
    }

    public static UserCreationRequestBody createWithDefaultValues(){
        UserCreationRequestBody requestBody = new UserCreationRequestBody();
        requestBody.setAccountRole("USER");
        requestBody.setDefaultProject("superadmin_personal");
        requestBody.setEmail(EMAIL);
        requestBody.setFullName(LOGIN + " " + PASSWORD);
        requestBody.setLogin(LOGIN);
        requestBody.setPassword(PASSWORD);
        requestBody.setProjectRole("CUSTOMER");
        return requestBody;
    }


}
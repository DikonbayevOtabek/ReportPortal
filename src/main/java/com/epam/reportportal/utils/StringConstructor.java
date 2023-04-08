package com.epam.reportportal.utils;

import java.util.Random;

public class StringConstructor {
    private static final String ALFA_NUMERICAL_ALL_LOWER_CASE = "0123456789abcdefghijklmnopqrstuvwxyz";
    private static final Random random = new Random();
    private StringConstructor(){
        throw new IllegalStateException("It is prohibited to create instance of " + StringConstructor.class);
    }

    public static String generatePatternDescriptionTestData() {
        return "testAnchor"
                + random.nextInt(15) + "-"
                + random.nextInt(20) + "-"
                + random.nextInt(50);
    }


    public static String getRandomString(int stringLength){
        StringBuilder stringBuilder = new StringBuilder(stringLength);
        for(int i = 0; i < stringLength; ++i){
            stringBuilder.append(ALFA_NUMERICAL_ALL_LOWER_CASE.charAt(random.nextInt(ALFA_NUMERICAL_ALL_LOWER_CASE.length())));
        }
        return stringBuilder.toString();
    }

    public static String generateRandomUsername(int postfixLength){
        return "User".concat(getRandomString(postfixLength));
    }

    public static String generateRandomPassword(int postfixLength){
        return "Password".concat(getRandomString(postfixLength));
    }
    public static String generateRandomEmail(int postfixLength){
        return "guest".concat(getRandomString(postfixLength)) +  "@epam.com";
    }
}

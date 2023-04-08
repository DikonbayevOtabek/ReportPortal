package com.epam.reportportal.product.buisness.objects.settings.general;

import com.epam.reportportal.framework.configuration.PropertyDataReader;

public class GeneralSettingsConfigFactory {
    private static final String LAUNCH_INACTIVITY_TIMEOUT_KEY = "report-portal.bo.settings.general.launch-inactivity-timeout";

    private GeneralSettingsConfigFactory(){
        throw new IllegalStateException("It is prohibited to create instance of " + GeneralSettingsConfigFactory.class);
    }

    public static GeneralSettingsConfig withLaunchInactivityTimeoutFromProperties() {
        return new GeneralSettingsConfig.Builder()
                .launchInactivityTimeout(PropertyDataReader.getDataByKey(LAUNCH_INACTIVITY_TIMEOUT_KEY)).build();
    }

    public static GeneralSettingsConfig withLaunchInactivityTimeoutFromFeature(String launchInactivityTimeoutFromFeature) {
        return new GeneralSettingsConfig.Builder().launchInactivityTimeout(launchInactivityTimeoutFromFeature).build();
    }
}

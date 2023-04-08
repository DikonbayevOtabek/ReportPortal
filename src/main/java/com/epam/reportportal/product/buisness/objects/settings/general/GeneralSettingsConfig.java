package com.epam.reportportal.product.buisness.objects.settings.general;

import java.util.Objects;

public final class GeneralSettingsConfig {
    private final String launchInactivityTimeoutOption;
    private final String keepLaunchesOption;
    private final String keepLogsOption;
    private final String keepAttachmentsOption;

    public GeneralSettingsConfig(Builder builder) {
        this.launchInactivityTimeoutOption = builder.launchInactivityTimeoutOption;
        this.keepLaunchesOption = builder.keepLaunchesOption;
        this.keepLogsOption = builder.keepLogsOption;
        this.keepAttachmentsOption = builder.keepAttachmentsOption;
    }

    public String getLaunchInactivityTimeoutOption() {
        return launchInactivityTimeoutOption;
    }

    public String getKeepLaunchesOption() {
        return keepLaunchesOption;
    }

    public String getKeepLogsOption() {
        return keepLogsOption;
    }

    public String getKeepAttachmentsOption() {
        return keepAttachmentsOption;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GeneralSettingsConfig that = (GeneralSettingsConfig) o;
        return Objects.equals(launchInactivityTimeoutOption, that.launchInactivityTimeoutOption) && Objects.equals(keepLaunchesOption, that.keepLaunchesOption) && Objects.equals(keepLogsOption, that.keepLogsOption) && Objects.equals(keepAttachmentsOption, that.keepAttachmentsOption);
    }

    @Override
    public int hashCode() {
        return Objects.hash(launchInactivityTimeoutOption, keepLaunchesOption, keepLogsOption, keepAttachmentsOption);
    }

    @Override
    public String toString() {
        return "GeneralSettingsConfig{" +
                "launchInactivityTimeoutOption='" + launchInactivityTimeoutOption + '\'' +
                ", keepLaunchesOption='" + keepLaunchesOption + '\'' +
                ", keepLogsOption='" + keepLogsOption + '\'' +
                ", keepAttachmentsOption='" + keepAttachmentsOption + '\'' +
                '}';
    }

    public static class Builder {
        private String launchInactivityTimeoutOption;
        private String keepLaunchesOption;
        private String keepLogsOption;
        private String keepAttachmentsOption;

        public Builder launchInactivityTimeout(String option) {
            launchInactivityTimeoutOption = option;
            return this;
        }

        public Builder keepLaunches(String option) {
            keepLaunchesOption = option;
            return this;
        }

        public Builder keepLogs(String option) {
            keepLogsOption = option;
            return this;
        }

        public Builder keepAttachments(String option) {
            keepAttachmentsOption = option;
            return this;
        }

        public GeneralSettingsConfig build() {
            return new GeneralSettingsConfig(this);
        }
    }
}

package com.epam.reportportal.product.http.model.request.user;

public class UserCreationRequestBody {

    private String accountRole;
    private String defaultProject;
    private String email;
    private String fullName;
    private String login;
    private String password;
    private String projectRole;

    public void setAccountRole(String accountRole) {
        this.accountRole = accountRole;
    }

    public void setDefaultProject(String defaultProject) {
        this.defaultProject = defaultProject;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setProjectRole(String projectRole) {
        this.projectRole = projectRole;
    }


    @Override
    public String toString() {
        return "{\n" +
                "  \"accountRole\":" + "\"" + accountRole + "\"" + ",\n" +
                "  \"defaultProject\":" + "\"" + defaultProject + "\"" + ",\n" +
                "  \"email\":" + "\"" + email + "\"" + ",\n" +
                "  \"fullName\":" + "\"" + fullName + "\"" + ",\n" +
                "  \"login\":" + "\"" + login+ "\"" + ",\n" +
                "  \"password\":" + "\"" + password +"\"" + ",\n" +
                "  \"projectRole\":" + "\"" +projectRole +"\"" + "\n" +
                "}";
    }
}

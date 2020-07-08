package com.app.qartechnician.models.log_in_model.log_in_request;

public class LogInEmailRequest {

    private String email;
    private String password;
    private String loginAs;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLoginAs() {
        return loginAs;
    }

    public void setLoginAs(String loginAs) {
        this.loginAs = loginAs;
    }
}

package com.app.qartechnician.models.change_password.change_password_request;

public class ChangePasswordRequest {

    private int oldPassword;
    private int newPassword;
    private String loginAs;

    public int getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(int oldPassword) {
        this.oldPassword = oldPassword;
    }

    public int getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(int newPassword) {
        this.newPassword = newPassword;
    }

    public String getLoginAs() {
        return loginAs;
    }

    public void setLoginAs(String loginAs) {
        this.loginAs = loginAs;
    }
}

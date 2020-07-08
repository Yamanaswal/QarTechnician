package com.app.qartechnician.models.change_password.change_password_response;

public class ChangePasswordResponse {

    private int Code;
    private String message;
    private ChangePasswordResponseData data;

    public int getCode() {
        return Code;
    }

    public void setCode(int code) {
        Code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ChangePasswordResponseData getData() {
        return data;
    }

    public void setData(ChangePasswordResponseData data) {
        this.data = data;
    }
}

package com.app.qartechnician.models.log_in_model.log_in_response;

public class LogInEmailResponse {

    private int Code;
    private String message;
    private LogInEmailResponseData data;

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

    public LogInEmailResponseData getData() {
        return data;
    }

    public void setData(LogInEmailResponseData data) {
        this.data = data;
    }

}

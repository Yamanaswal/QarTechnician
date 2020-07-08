package com.app.qartechnician.models.log_in_model.log_in_response;

public class LogInEmailResponseData {

    private LogInEmailResponseUser user;
    private String Token;
    private double wallet;

    public LogInEmailResponseUser getUser() {
        return user;
    }

    public void setUser(LogInEmailResponseUser user) {
        this.user = user;
    }

    public String getToken() {
        return Token;
    }

    public void setToken(String token) {
        Token = token;
    }

    public double getWallet() {
        return wallet;
    }

    public void setWallet(double wallet) {
        this.wallet = wallet;
    }
}

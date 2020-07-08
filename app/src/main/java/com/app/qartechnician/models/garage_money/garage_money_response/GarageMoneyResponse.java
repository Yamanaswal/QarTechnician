package com.app.qartechnician.models.garage_money.garage_money_response;

public class GarageMoneyResponse {

    private int Code;
    private String message;
    private GarageMoneyResponseData data;

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

    public GarageMoneyResponseData getData() {
        return data;
    }

    public void setData(GarageMoneyResponseData data) {
        this.data = data;
    }
}

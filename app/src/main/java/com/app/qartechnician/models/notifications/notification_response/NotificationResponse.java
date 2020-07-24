package com.app.qartechnician.models.notifications.notification_response;

import com.app.qartechnician.models.garage_money.garage_money_response.GarageMoneyResponseData;

import java.util.List;

public class NotificationResponse {

    private int Code;
    private String message;
    private List<NotificationResponseData> data;

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

    public List<NotificationResponseData> getData() {
        return data;
    }

    public void setData(List<NotificationResponseData> data) {
        this.data = data;
    }
}

package com.app.qartechnician.models.upcoming_order.upcoimg_order_response;

import java.util.List;

public class UpcomingOrderResponse {

    private int Code;
    private String message;
    private List<UpcomingOrderResponseData> data;

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

    public List<UpcomingOrderResponseData> getData() {
        return data;
    }

    public void setData(List<UpcomingOrderResponseData> data) {
        this.data = data;
    }
}

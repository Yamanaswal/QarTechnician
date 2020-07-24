package com.app.qartechnician.models.ongoing_order.ongoing_order_response;

import java.util.List;

public class OnGoingOrderResponse {

    private int Code;
    private String message;
    private List<OnGoingOrderResponseData> data;

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

    public List<OnGoingOrderResponseData> getData() {
        return data;
    }

    public void setData(List<OnGoingOrderResponseData> data) {
        this.data = data;
    }


}

package com.app.qartechnician.models.garage_money_admin.garage_money_admin_response;

import com.app.qartechnician.models.log_in_model.log_in_response.LogInEmailResponseData;

public class GarageMoneyAdminResponse {

    private int Code;
    private String message;
    private GarageMoneyAdminResponseData data;

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

    public GarageMoneyAdminResponseData getData() {
        return data;
    }

    public void setData(GarageMoneyAdminResponseData data) {
        this.data = data;
    }
}

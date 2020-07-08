package com.app.qartechnician.models.dashboard_data.dashboard_data_response;

public class DashboardDataResponse {

    private int Code;
    private String message;
    private DashboardDataResponseData data;

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

    public DashboardDataResponseData getData() {
        return data;
    }

    public void setData(DashboardDataResponseData data) {
        this.data = data;
    }
}

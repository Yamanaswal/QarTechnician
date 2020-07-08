package com.app.qartechnician.models.technician_list.technician_list_response;

public class TechnicianListResponse {

    private int Code;
    private String message;
    private TechnicianListResponseData data;

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

    public TechnicianListResponseData getData() {
        return data;
    }

    public void setData(TechnicianListResponseData data) {
        this.data = data;
    }
}

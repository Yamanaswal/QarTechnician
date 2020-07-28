package com.app.qartechnician.models.calendar_management.calendar_management_response;

public class CalendarManageResponse {

    private int Code;
    private String message;
    private CalendarManageResponseData data;

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

    public CalendarManageResponseData getData() {
        return data;
    }

    public void setData(CalendarManageResponseData data) {
        this.data = data;
    }
}

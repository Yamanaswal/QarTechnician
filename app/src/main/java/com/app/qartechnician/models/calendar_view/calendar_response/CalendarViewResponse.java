package com.app.qartechnician.models.calendar_view.calendar_response;

public class CalendarViewResponse {


    private int Code;
    private String message;
    private CalendarViewResponseData data;

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

    public CalendarViewResponseData getData() {
        return data;
    }

    public void setData(CalendarViewResponseData data) {
        this.data = data;
    }
}

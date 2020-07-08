package com.app.qartechnician.models.status_pending.status_pending_response;

import java.util.List;

public class StatusPendingResponse {

    private int Code;
    private String message;
    private List<StatusPendingResponseData> data;

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

    public List<StatusPendingResponseData> getData() {
        return data;
    }

    public void setData(List<StatusPendingResponseData> data) {
        this.data = data;
    }
}

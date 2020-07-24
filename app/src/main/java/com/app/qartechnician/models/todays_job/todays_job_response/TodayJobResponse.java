package com.app.qartechnician.models.todays_job.todays_job_response;

import java.util.List;

public class TodayJobResponse {

    private int Code;
    private String message;
    private List<TodayJobResponseData> data;

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

    public List<TodayJobResponseData> getData() {
        return data;
    }

    public void setData(List<TodayJobResponseData> data) {
        this.data = data;
    }
}

package com.app.qartechnician.models.my_appointment.my_appointment_request;

public class MyAppointmentRequest {

    private String loginAs;
    private String status;
    private String fromDate;
    private String toDate;

    public String getLoginAs() {
        return loginAs;
    }

    public void setLoginAs(String loginAs) {
        this.loginAs = loginAs;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }
}

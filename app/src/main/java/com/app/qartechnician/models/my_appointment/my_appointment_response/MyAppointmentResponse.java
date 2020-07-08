package com.app.qartechnician.models.my_appointment.my_appointment_response;

import com.app.qartechnician.models.profile_details.profile_details_response.ProfileDetailsResponseData;

import java.util.List;

public class MyAppointmentResponse {

    private int Code;
    private String message;
    private List<MyAppointmentResponseData> data;

    public List<MyAppointmentResponseData> getData() {
        return data;
    }

    public void setData(List<MyAppointmentResponseData> data) {
        this.data = data;
    }

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

}

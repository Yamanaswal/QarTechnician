package com.app.qartechnician.models.manage_technician.manage_technician_response;

import com.app.qartechnician.models.technician_list.technician_list_response.TechnicianListResponseData;

public class ManageTechnicianResponse {

    private int Code;
    private String message;
    private ManageTechnicianResponseData data;

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

    public ManageTechnicianResponseData getData() {
        return data;
    }

    public void setData(ManageTechnicianResponseData data) {
        this.data = data;
    }
}

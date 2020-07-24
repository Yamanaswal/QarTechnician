package com.app.qartechnician.models.profile_update.profile_update_response;

import com.app.qartechnician.models.raise_quotation.raise_quotation_response.RaiseQuotationResponseData;

public class ProfileUpdateResponse {

    private int Code;
    private String message;
    private ProfileUpdateResponseData data;

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

    public ProfileUpdateResponseData getData() {
        return data;
    }

    public void setData(ProfileUpdateResponseData data) {
        this.data = data;
    }
}

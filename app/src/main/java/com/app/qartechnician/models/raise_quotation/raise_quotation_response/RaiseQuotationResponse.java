package com.app.qartechnician.models.raise_quotation.raise_quotation_response;

public class RaiseQuotationResponse {

    private int Code;
    private String message;
    private RaiseQuotationResponseData data;

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

    public RaiseQuotationResponseData getData() {
        return data;
    }

    public void setData(RaiseQuotationResponseData data) {
        this.data = data;
    }
}

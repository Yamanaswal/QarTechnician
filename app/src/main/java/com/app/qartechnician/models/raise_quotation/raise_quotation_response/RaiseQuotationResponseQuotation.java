package com.app.qartechnician.models.raise_quotation.raise_quotation_response;

public class RaiseQuotationResponseQuotation {

    private String serviceType;
    private String requiredParts;
    private double amount;
    private String additionalFeedBack;
    private String requestStatus;
    private String time;
    private String _id;

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getRequiredParts() {
        return requiredParts;
    }

    public void setRequiredParts(String requiredParts) {
        this.requiredParts = requiredParts;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getAdditionalFeedBack() {
        return additionalFeedBack;
    }

    public void setAdditionalFeedBack(String additionalFeedBack) {
        this.additionalFeedBack = additionalFeedBack;
    }

    public String getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(String requestStatus) {
        this.requestStatus = requestStatus;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }
}

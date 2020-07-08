package com.app.qartechnician.models.raise_quotation.raise_quotation_request;

public class RaiseQuotationRequest {

    private String loginAs;
    private String serviceType;
    private String requiredParts;
    private String additionalFeedBack;
    private String bookingId;
    private double amount;

    public String getLoginAs() {
        return loginAs;
    }

    public void setLoginAs(String loginAs) {
        this.loginAs = loginAs;
    }

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

    public String getAdditionalFeedBack() {
        return additionalFeedBack;
    }

    public void setAdditionalFeedBack(String additionalFeedBack) {
        this.additionalFeedBack = additionalFeedBack;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}

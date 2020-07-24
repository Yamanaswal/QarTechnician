package com.app.qartechnician.models.terms_privacy_about_us.terms_privacy_about_response;

public class TermsPrivacyAboutUsResponse {

    private int Code;
    private String message;
    private TermsPrivacyAboutUsResponseData data;

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

    public TermsPrivacyAboutUsResponseData getData() {
        return data;
    }

    public void setData(TermsPrivacyAboutUsResponseData data) {
        this.data = data;
    }
}

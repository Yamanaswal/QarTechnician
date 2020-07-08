package com.app.qartechnician.models.profile_details.profile_details_response;

public class ProfileDetailsResponse {

    private int Code;
    private String message;
    private ProfileDetailsResponseData data;

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

    public ProfileDetailsResponseData getData() {
        return data;
    }

    public void setData(ProfileDetailsResponseData data) {
        this.data = data;
    }
}

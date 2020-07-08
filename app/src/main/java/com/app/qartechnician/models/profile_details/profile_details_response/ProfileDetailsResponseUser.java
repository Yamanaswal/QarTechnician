package com.app.qartechnician.models.profile_details.profile_details_response;

import com.google.gson.annotations.SerializedName;

public class ProfileDetailsResponseUser {

    private String _id;
    @SerializedName("GarageName")
    private String name;
    private String email;
    private String mobileNo;
    private boolean notification;
    private boolean visibility;
    private String avatar;
    private ProfileDetailsResponseAddress address;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public boolean isNotification() {
        return notification;
    }

    public void setNotification(boolean notification) {
        this.notification = notification;
    }

    public boolean isVisibility() {
        return visibility;
    }

    public void setVisibility(boolean visibility) {
        this.visibility = visibility;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public ProfileDetailsResponseAddress getAddress() {
        return address;
    }

    public void setAddress(ProfileDetailsResponseAddress address) {
        this.address = address;
    }
}

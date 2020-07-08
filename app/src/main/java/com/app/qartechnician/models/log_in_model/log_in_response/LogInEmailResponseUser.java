package com.app.qartechnician.models.log_in_model.log_in_response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LogInEmailResponseUser {

    private LoginEmailAddress address;
    private String name;
    private String userName;
    private String email;
    private String mobileNo;
    private String garageId;
    private List<String> serviceType;
    private String password;
    private boolean notification;
    private boolean visibility;
    private boolean accountStatus;
    private boolean deleteStatus;
    private String profileImage;
    private String experience;
    @SerializedName("for")
    private String for_val;
    private String createdBy;
    private String _id;
    private String createdAt;
    private String updatedAt;
    private int __v;

    public LoginEmailAddress getAddress() {
        return address;
    }

    public void setAddress(LoginEmailAddress address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public String getGarageId() {
        return garageId;
    }

    public void setGarageId(String garageId) {
        this.garageId = garageId;
    }

    public List<String> getServiceType() {
        return serviceType;
    }

    public void setServiceType(List<String> serviceType) {
        this.serviceType = serviceType;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public boolean isAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(boolean accountStatus) {
        this.accountStatus = accountStatus;
    }

    public boolean isDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(boolean deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getFor_val() {
        return for_val;
    }

    public void setFor_val(String for_val) {
        this.for_val = for_val;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int get__v() {
        return __v;
    }

    public void set__v(int __v) {
        this.__v = __v;
    }
}

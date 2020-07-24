package com.app.qartechnician.models.my_appointment.my_appointment_response;

import java.util.List;

public class MyAppointmentResponseData {

    private String _id;
    private String orderId;
    private String bookingDate;
    private String bookingFormTime;
    private String bookingToTime;
    private String modeOfPayment;
    private String createdAt;
    private List<MyAppointmentResponseDataOrderStatus> orderStatus;
    private double totalFee;
    private MyAppointmentResponseDataBooking bookingStatus;
    private String userId;
    private String fullName;
    private String mobileNo;
    private String companyName;
    private String vehicleNo;
    private String modelImage;
    private String bookingTime;
    private int time;
    private List<String> serviceName;
    private String reason;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getBookingFormTime() {
        return bookingFormTime;
    }

    public void setBookingFormTime(String bookingFormTime) {
        this.bookingFormTime = bookingFormTime;
    }

    public String getBookingToTime() {
        return bookingToTime;
    }

    public void setBookingToTime(String bookingToTime) {
        this.bookingToTime = bookingToTime;
    }

    public String getModeOfPayment() {
        return modeOfPayment;
    }

    public void setModeOfPayment(String modeOfPayment) {
        this.modeOfPayment = modeOfPayment;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public List<MyAppointmentResponseDataOrderStatus> getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(List<MyAppointmentResponseDataOrderStatus> orderStatus) {
        this.orderStatus = orderStatus;
    }

    public double getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(double totalFee) {
        this.totalFee = totalFee;
    }

    public MyAppointmentResponseDataBooking getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(MyAppointmentResponseDataBooking bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public String getModelImage() {
        return modelImage;
    }

    public void setModelImage(String modelImage) {
        this.modelImage = modelImage;
    }

    public String getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(String bookingTime) {
        this.bookingTime = bookingTime;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public List<String> getServiceName() {
        return serviceName;
    }

    public void setServiceName(List<String> serviceName) {
        this.serviceName = serviceName;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}

package com.app.qartechnician.models.upcoming_order.upcoimg_order_response;

import java.util.List;

public class UpcomingOrderResponseData {

    private String _id;
    private String orderId;
    private String bookingDate;
    private String bookingFormTime;
    private String bookingToTime;
    private double totalFee;
    private String fullName;
    private String companyName;
    private String vehicleNo;
    private String modelImage;
    private String bookingTime;
    private List<String> serviceName;

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

    public double getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(double totalFee) {
        this.totalFee = totalFee;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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

    public List<String> getServiceName() {
        return serviceName;
    }

    public void setServiceName(List<String> serviceName) {
        this.serviceName = serviceName;
    }
}

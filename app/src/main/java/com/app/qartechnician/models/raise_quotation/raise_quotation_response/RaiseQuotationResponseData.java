package com.app.qartechnician.models.raise_quotation.raise_quotation_response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RaiseQuotationResponseData {

    private RaiseQuotationResponseFees fees;
    private String orderId;
    private String bookingDate;
    private String bookingFormTime;
    private String bookingToTime;
    private String postalAddress;
    private double lat;
    @SerializedName("long")
    private double longitude;
    List<String> serviceId;
    private String transactionId;
    private String modeOfPayment;
    List<String> Images;
    private String _id;
    private String vehicleId;
    List<RaiseQuotationResponseOrderStatus> orderStatus;
    private String userId;
    private List<RaiseQuotationResponseAcceptStatus> acceptStatus;
    private List<RaiseQuotationResponseGarage> garage;
    private List<String> bookingStatus;
    private List<String> inspectionReport;
    private List<RaiseQuotationResponseQuotation> quotation;
    private List<String> report;
    private String createdAt;
    private int __v;


    public List<RaiseQuotationResponseGarage> getGarage() {
        return garage;
    }

    public void setGarage(List<RaiseQuotationResponseGarage> garage) {
        this.garage = garage;
    }

    public RaiseQuotationResponseFees getFees() {
        return fees;
    }

    public void setFees(RaiseQuotationResponseFees fees) {
        this.fees = fees;
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

    public String getPostalAddress() {
        return postalAddress;
    }

    public void setPostalAddress(String postalAddress) {
        this.postalAddress = postalAddress;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public List<String> getServiceId() {
        return serviceId;
    }

    public void setServiceId(List<String> serviceId) {
        this.serviceId = serviceId;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getModeOfPayment() {
        return modeOfPayment;
    }

    public void setModeOfPayment(String modeOfPayment) {
        this.modeOfPayment = modeOfPayment;
    }

    public List<String> getImages() {
        return Images;
    }

    public void setImages(List<String> images) {
        Images = images;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public List<RaiseQuotationResponseOrderStatus> getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(List<RaiseQuotationResponseOrderStatus> orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<RaiseQuotationResponseAcceptStatus> getAcceptStatus() {
        return acceptStatus;
    }

    public void setAcceptStatus(List<RaiseQuotationResponseAcceptStatus> acceptStatus) {
        this.acceptStatus = acceptStatus;
    }

    public List<String> getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(List<String> bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public List<String> getInspectionReport() {
        return inspectionReport;
    }

    public void setInspectionReport(List<String> inspectionReport) {
        this.inspectionReport = inspectionReport;
    }

    public List<RaiseQuotationResponseQuotation> getQuotation() {
        return quotation;
    }

    public void setQuotation(List<RaiseQuotationResponseQuotation> quotation) {
        this.quotation = quotation;
    }

    public List<String> getReport() {
        return report;
    }

    public void setReport(List<String> report) {
        this.report = report;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public int get__v() {
        return __v;
    }

    public void set__v(int __v) {
        this.__v = __v;
    }
}

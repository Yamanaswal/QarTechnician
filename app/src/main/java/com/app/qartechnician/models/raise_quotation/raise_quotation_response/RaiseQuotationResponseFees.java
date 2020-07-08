package com.app.qartechnician.models.raise_quotation.raise_quotation_response;

public class RaiseQuotationResponseFees {

    private double price;
    private double serviceCharge;
    private double discount;
    private double walletBalance;
    private double couponBalance;
    private double otherTaxes;
    private double total;
    private double gst;
    private double cgst;
    private double igst;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getServiceCharge() {
        return serviceCharge;
    }

    public void setServiceCharge(double serviceCharge) {
        this.serviceCharge = serviceCharge;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getWalletBalance() {
        return walletBalance;
    }

    public void setWalletBalance(double walletBalance) {
        this.walletBalance = walletBalance;
    }

    public double getCouponBalance() {
        return couponBalance;
    }

    public void setCouponBalance(double couponBalance) {
        this.couponBalance = couponBalance;
    }

    public double getOtherTaxes() {
        return otherTaxes;
    }

    public void setOtherTaxes(double otherTaxes) {
        this.otherTaxes = otherTaxes;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getGst() {
        return gst;
    }

    public void setGst(double gst) {
        this.gst = gst;
    }

    public double getCgst() {
        return cgst;
    }

    public void setCgst(double cgst) {
        this.cgst = cgst;
    }

    public double getIgst() {
        return igst;
    }

    public void setIgst(double igst) {
        this.igst = igst;
    }
}

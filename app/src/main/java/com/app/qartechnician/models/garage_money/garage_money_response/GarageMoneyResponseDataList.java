package com.app.qartechnician.models.garage_money.garage_money_response;

public class GarageMoneyResponseDataList {

    private GarageMoneyResponseDataListWallet wallet;
    private GarageMoneyResponseDataListBooking booking;

    public GarageMoneyResponseDataListWallet getWallet() {
        return wallet;
    }

    public void setWallet(GarageMoneyResponseDataListWallet wallet) {
        this.wallet = wallet;
    }

    public GarageMoneyResponseDataListBooking getBooking() {
        return booking;
    }

    public void setBooking(GarageMoneyResponseDataListBooking booking) {
        this.booking = booking;
    }
}

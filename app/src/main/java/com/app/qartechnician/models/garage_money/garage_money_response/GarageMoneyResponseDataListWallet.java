package com.app.qartechnician.models.garage_money.garage_money_response;

public class GarageMoneyResponseDataListWallet {

    private double amount;
    private String statement;
    private String transactionType;
    private String bookingId;
    private String _id;
    private String createdAt;
    private double currentAmount;
    private String withdrawalRequest;

    public String getWithdrawalRequest() {
        return withdrawalRequest;
    }

    public void setWithdrawalRequest(String withdrawalRequest) {
        this.withdrawalRequest = withdrawalRequest;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
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

    public double getCurrentAmount() {
        return currentAmount;
    }

    public void setCurrentAmount(double currentAmount) {
        this.currentAmount = currentAmount;
    }
}

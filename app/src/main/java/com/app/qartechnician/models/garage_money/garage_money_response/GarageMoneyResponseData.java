package com.app.qartechnician.models.garage_money.garage_money_response;

import java.util.List;

public class GarageMoneyResponseData {

    private List<GarageMoneyResponseDataList> list;
    private double totalEarnings;

    public List<GarageMoneyResponseDataList> getList() {
        return list;
    }

    public void setList(List<GarageMoneyResponseDataList> list) {
        this.list = list;
    }

    public double getTotalEarnings() {
        return totalEarnings;
    }

    public void setTotalEarnings(double totalEarnings) {
        this.totalEarnings = totalEarnings;
    }
}

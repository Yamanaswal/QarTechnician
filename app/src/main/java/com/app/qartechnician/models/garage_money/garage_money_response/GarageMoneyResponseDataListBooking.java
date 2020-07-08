package com.app.qartechnician.models.garage_money.garage_money_response;

import java.util.List;

public class GarageMoneyResponseDataListBooking {

    private String _id;
    List<String> serviceName;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public List<String> getServiceName() {
        return serviceName;
    }

    public void setServiceName(List<String> serviceName) {
        this.serviceName = serviceName;
    }
}

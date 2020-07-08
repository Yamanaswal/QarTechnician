package com.app.qartechnician.models.garage_money_admin.garage_money_admin_response;

import java.util.List;

public class GarageMoneyAdminResponseData {

    private String _id;
    private String garageId;
    private List<GarageMoneyAdminResponseWallet> wallet;
    private String createdAt;
    private String updatedAt;
    private int __v;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getGarageId() {
        return garageId;
    }

    public void setGarageId(String garageId) {
        this.garageId = garageId;
    }

    public List<GarageMoneyAdminResponseWallet> getWallet() {
        return wallet;
    }

    public void setWallet(List<GarageMoneyAdminResponseWallet> wallet) {
        this.wallet = wallet;
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

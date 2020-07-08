package com.app.qartechnician.models.technician_list.technician_list_response;

public class TechnicianListResponseDataList {

    private String _id;
    private String name;
    private String permission;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }
}

package com.app.qartechnician.models.manage_technician.manage_technician_request;

public class ManageTechnicianRequest {

    private String technicianId;
    private String permission;

    public String getTechnicianId() {
        return technicianId;
    }

    public void setTechnicianId(String technicianId) {
        this.technicianId = technicianId;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }
}

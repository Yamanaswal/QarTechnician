package com.app.qartechnician.models.technician_list.technician_list_response;

import java.util.List;

public class TechnicianListResponseData {

    private int Total;
    private List<TechnicianListResponseDataList> list;

    public int getTotal() {
        return Total;
    }

    public void setTotal(int total) {
        Total = total;
    }

    public List<TechnicianListResponseDataList> getList() {
        return list;
    }

    public void setList(List<TechnicianListResponseDataList> list) {
        this.list = list;
    }
}

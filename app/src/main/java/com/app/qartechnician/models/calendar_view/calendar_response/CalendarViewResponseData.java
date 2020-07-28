package com.app.qartechnician.models.calendar_view.calendar_response;

import java.util.List;

public class CalendarViewResponseData {

    private String wkdate;
    private List<CalendarViewResponseDataBooking> booking;

    public String getWkdate() {
        return wkdate;
    }

    public void setWkdate(String wkdate) {
        this.wkdate = wkdate;
    }

    public List<CalendarViewResponseDataBooking> getBooking() {
        return booking;
    }

    public void setBooking(List<CalendarViewResponseDataBooking> booking) {
        this.booking = booking;
    }
}

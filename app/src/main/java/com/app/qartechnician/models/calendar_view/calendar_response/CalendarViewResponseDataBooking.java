package com.app.qartechnician.models.calendar_view.calendar_response;

public class CalendarViewResponseDataBooking {

    private boolean isBooked;
    private boolean isUnAvailable;
    private String fromTime;
    private String toTime;

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }

    public boolean isUnAvailable() {
        return isUnAvailable;
    }

    public void setUnAvailable(boolean unAvailable) {
        isUnAvailable = unAvailable;
    }

    public String getFromTime() {
        return fromTime;
    }

    public void setFromTime(String fromTime) {
        this.fromTime = fromTime;
    }

    public String getToTime() {
        return toTime;
    }

    public void setToTime(String toTime) {
        this.toTime = toTime;
    }
}

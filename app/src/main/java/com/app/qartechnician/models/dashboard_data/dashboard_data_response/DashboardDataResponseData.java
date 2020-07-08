package com.app.qartechnician.models.dashboard_data.dashboard_data_response;

public class DashboardDataResponseData {

    private int upcommingAppointments;
    private int ongoingAppointment;
    private int todayAppointment;
    private int notification;
    private double wallet;

    public int getUpcommingAppointments() {
        return upcommingAppointments;
    }

    public void setUpcommingAppointments(int upcommingAppointments) {
        this.upcommingAppointments = upcommingAppointments;
    }

    public int getOngoingAppointment() {
        return ongoingAppointment;
    }

    public void setOngoingAppointment(int ongoingAppointment) {
        this.ongoingAppointment = ongoingAppointment;
    }

    public int getTodayAppointment() {
        return todayAppointment;
    }

    public void setTodayAppointment(int todayAppointment) {
        this.todayAppointment = todayAppointment;
    }

    public int getNotification() {
        return notification;
    }

    public void setNotification(int notification) {
        this.notification = notification;
    }

    public double getWallet() {
        return wallet;
    }

    public void setWallet(double wallet) {
        this.wallet = wallet;
    }
}

package com.app.qartechnician.models.profile_details.profile_details_response;

public class ProfileDetailsResponseData {

    private ProfileDetailsResponseUser user;
    private double wallet;

    public ProfileDetailsResponseUser getUser() {
        return user;
    }

    public void setUser(ProfileDetailsResponseUser user) {
        this.user = user;
    }

    public double getWallet() {
        return wallet;
    }

    public void setWallet(double wallet) {
        this.wallet = wallet;
    }
}

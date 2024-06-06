package com.techelevator.model;

import java.math.BigDecimal;

public class Donation {
    int donationId;
    int donorId;
    int campaignId;
    BigDecimal amount;
    public Donation(){}

    public int getDonationId() {
        return donationId;
    }

    public void setDonationId(int donationId) {
        this.donationId = donationId;
    }

    public int getDonorId() {
        return donorId;
    }

    public void setDonorId(int donorId) {
        this.donorId = donorId;
    }

    public int getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(int campaignId) {
        this.campaignId = campaignId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Donation(int donationId, int donorId, int campaignId, BigDecimal amount) {
        this.donationId = donationId;
        this.donorId = donorId;
        this.campaignId = campaignId;
        this.amount = amount;
    }


}

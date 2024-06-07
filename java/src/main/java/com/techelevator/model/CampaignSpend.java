package com.techelevator.model;

public class CampaignSpend {
    int spendRequestId;
    int campaignId;

    public CampaignSpend(int spendRequestId, int campaignId) {
        this.spendRequestId = spendRequestId;
        this.campaignId = campaignId;
    }

    public int getSpendRequestId() {
        return spendRequestId;
    }

    public void setSpendRequestId(int spendRequestId) {
        this.spendRequestId = spendRequestId;
    }

    public int getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(int campaignId) {
        this.campaignId = campaignId;
    }
}

package com.techelevator.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Campaign {
    int campaignId;
    String campaignTitle;
//    LocalDate campaignStartDate;
    String campaignStartDate;
    LocalDate campaignEndDate;
    BigDecimal campaignGoal;
    int campaignOwnerId;
    String campaignImageURL;
    BigDecimal fundingProgress;

    public Campaign() { }

    public Campaign(int campaignId, String campaignTitle, String campaignStartDate, LocalDate campaignEndDate, BigDecimal campaignGoal, int campaignOwnerId, String campaignImageURL, BigDecimal fundingProgress) {
        this.campaignId = campaignId;
        this.campaignTitle = campaignTitle;
        this.campaignStartDate = campaignStartDate;
        this.campaignEndDate = campaignEndDate;
        this.campaignGoal = campaignGoal;
        this.campaignOwnerId = campaignOwnerId;
        this.campaignImageURL = campaignImageURL;
        this.fundingProgress = fundingProgress;
    }

    public int getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(int campaignId) {
        this.campaignId = campaignId;
    }

    public String getCampaignTitle() {
        return campaignTitle;
    }

    public void setCampaignTitle(String campaignTitle) {
        this.campaignTitle = campaignTitle;
    }

    public String getCampaignStartDate() {
        return campaignStartDate;
    }

    public void setCampaignStartDate(String campaignStartDate) {
        this.campaignStartDate = campaignStartDate;
    }

    public LocalDate getCampaignEndDate() {
        return campaignEndDate;
    }

    public void setCampaignEndDate(LocalDate campaignEndDate) {
        this.campaignEndDate = campaignEndDate;
    }

    public BigDecimal getCampaignGoal() {
        return campaignGoal;
    }

    public void setCampaignGoal(BigDecimal campaignGoal) {
        this.campaignGoal = campaignGoal;
    }

    public int getCampaignOwnerId() {
        return campaignOwnerId;
    }

    public void setCampaignOwnerId(int campaignOwnerId) {
        this.campaignOwnerId = campaignOwnerId;
    }

    public String getCampaignImageURL() {
        return campaignImageURL;
    }

    public void setCampaignImageURL(String campaignImageURL) {
        this.campaignImageURL = campaignImageURL;
    }

    public BigDecimal getFundingProgress() {
        return fundingProgress;
    }

    public void setFundingProgress(BigDecimal fundingProgress) {
        this.fundingProgress = fundingProgress;
    }
}

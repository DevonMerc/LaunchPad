package com.techelevator.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Campaign {
    int campaignId;
    String title;
//    LocalDate campaignStartDate;
//    String campaignStartDate;
    LocalDate endDate;
    BigDecimal goal;
    int managerId;
    String imgURL;
    BigDecimal funding;
    String description;
    boolean visibility;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public BigDecimal getGoal() {
        return goal;
    }

    public void setGoal(BigDecimal goal) {
        this.goal = goal;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public BigDecimal getFunding() {
        return funding;
    }

    public void setFunding(BigDecimal funding) {
        this.funding = funding;
    }

    public Campaign(int campaignId, String title, LocalDate endDate, BigDecimal goal, int managerId, String imgURL, BigDecimal funding, boolean visibility, String description) {
        this.campaignId = campaignId;
        this.title = title;
        this.endDate = endDate;
        this.goal = goal;
        this.managerId = managerId;
        this.imgURL = imgURL;
        this.funding = funding;
        this.visibility = visibility;
        this.description = description;
    }



    public boolean isVisibility() {
        return visibility;
    }

    public void setVisibility(boolean visibility) {
        this.visibility = visibility;
    }



    public Campaign() { }

//    public Campaign(int campaignId, String campaignTitle, LocalDate campaignEndDate, BigDecimal campaignGoal, int campaignOwnerId, String campaignImageURL, BigDecimal fundingProgress, boolean visibility) {
//        this.campaignId = campaignId;
//        this.campaignTitle = campaignTitle;
////        this.campaignStartDate = campaignStartDate;
//        this.campaignEndDate = campaignEndDate;
//        this.campaignGoal = campaignGoal;
//        this.campaignOwnerId = campaignOwnerId;
//        this.campaignImageURL = campaignImageURL;
//        this.fundingProgress = fundingProgress;
//        this.visibility = visibility;
//    }

    public int getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(int campaignId) {
        this.campaignId = campaignId;
    }
//
//    public String getCampaignTitle() {
//        return campaignTitle;
//    }
//
//    public void setCampaignTitle(String campaignTitle) {
//        this.campaignTitle = campaignTitle;
//    }
//
////    public String getCampaignStartDate() {
////        return campaignStartDate;
////    }
////
////    public void setCampaignStartDate(String campaignStartDate) {
////        this.campaignStartDate = campaignStartDate;
////    }
//
//    public LocalDate getCampaignEndDate() {
//        return campaignEndDate;
//    }
//
//    public void setCampaignEndDate(LocalDate campaignEndDate) {
//        this.campaignEndDate = campaignEndDate;
//    }
//
//    public BigDecimal getCampaignGoal() {
//        return campaignGoal;
//    }
//
//    public void setCampaignGoal(BigDecimal campaignGoal) {
//        this.campaignGoal = campaignGoal;
//    }
//
//    public int getCampaignOwnerId() {
//        return campaignOwnerId;
//    }
//
//    public void setCampaignOwnerId(int campaignOwnerId) {
//        this.campaignOwnerId = campaignOwnerId;
//    }
//
//    public String getCampaignImageURL() {
//        return campaignImageURL;
//    }
//
//    public void setCampaignImageURL(String campaignImageURL) {
//        this.campaignImageURL = campaignImageURL;
//    }
//
//    public BigDecimal getFundingProgress() {
//        return fundingProgress;
//    }
//
//    public void setFundingProgress(BigDecimal fundingProgress) {
//        this.fundingProgress = fundingProgress;
//    }
}

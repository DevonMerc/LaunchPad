package com.techelevator.dao;

import com.techelevator.model.Campaign;

import java.util.List;

public interface CampaignDao {

    List<Campaign> getPublicCampaigns(); //for home page
    List<Campaign> getCampaignsByUserId(int id); //for dashboard
    List<Campaign> getCampaignsBySearch(String searchTerm); //for home page
    Campaign getCampaignById(int id);
    Campaign createCampaign(Campaign campaign);
    boolean updateCampaign(int id);

}

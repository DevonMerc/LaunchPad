package com.techelevator.dao;

import com.techelevator.model.Campaign;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface CampaignDao {

    List<Campaign> getPublicCampaigns(); //for home page
    List<Campaign> getCampaignsByManagerId(int id); //for dashboard
    List<Campaign> getCampaignsByDonorId(int id);
    List<Campaign> getCampaignsBySearch(String searchTerm); //for home page
    Campaign getCampaignById(int id);
    Campaign createCampaign(String title, LocalDate endDate, BigDecimal goal, int managerId, String imgURL, BigDecimal funding, boolean visibility, String description);
    boolean updateCampaign(String title, LocalDate endDate, BigDecimal goal, String imgURL, boolean visibility, String description, int id);

}

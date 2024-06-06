package com.techelevator.controller;

import com.techelevator.model.Campaign;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin
public class CampaignController {

    //Need DAO for campaign table both Interface and jdbc implementation
    //Need model/DTO of campaign
    //inject them in.


    //endpoints related to getting campaign data
    //remember annotations
    //get list campaign Two, one for all public campaigns, one for getting list of user only campaigns.
    //get individual campaign based on id
    //post individual campaign
    //put indiviudal campaign based on id


//    List<Campaign> getPublicCampaigns(); //for home page
//    List<Campaign> getCampaignsByManagerId(int id); //for dashboard
//    List<Campaign> getCampaignsByDonorId(int id);
//    List<Campaign> getCampaignsBySearch(String searchTerm); //for home page
//    Campaign getCampaignById(int id);
//    Campaign createCampaign(String title, LocalDate endDate, BigDecimal goal, int managerId, String imgURL, BigDecimal funding, boolean visibility, String description);
//    boolean updateCampaign(String title, LocalDate endDate, BigDecimal goal, String imgURL, boolean visibility, String description, int id);

}

package com.techelevator.controller;

import com.techelevator.dao.CampaignDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Campaign;
import com.techelevator.service.CampaignService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.security.Principal;
import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin
public class CampaignController {

    RestTemplate restTemplate = new RestTemplate();
    private CampaignService campaignService;
    public CampaignController(CampaignService campaignService){
        this.campaignService = campaignService;
    }

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
//    Campaign createCampaign(Campaign campaign);
//    boolean updateCampaign(Campaign campaign);

    @RequestMapping(path = "/campaigns", method = RequestMethod.GET)
    public List<Campaign> getFeaturedCampaigns(){
        return campaignService.getFeaturedCampaigns();
    }

    @RequestMapping(path = "/user-campaigns", method = RequestMethod.GET)
    public List<Campaign> getUserCampaigns(Principal userInfo){
        return campaignService.getUserCampaigns(userInfo);
    }

}

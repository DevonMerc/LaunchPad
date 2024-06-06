package com.techelevator.service;

import com.techelevator.dao.CampaignDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Campaign;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.security.Principal;
import java.util.List;

@Service
public class CampaignService {
    private RestTemplate restTemplate = new RestTemplate();
    private CampaignDao campaignDao;
    private UserDao userDao;
    public CampaignService(CampaignDao campaignDao, UserDao userDao){
        this.campaignDao = campaignDao;
        this.userDao = userDao;
    }

    public List<Campaign> getFeaturedCampaigns(){
        return campaignDao.getFeaturedCampaigns();
    }

    public List<Campaign> getUserCampaigns(Principal userInfo){
        int userId = userDao.getUserByUsername(userInfo.getName()).getId();
        return campaignDao.getCampaignsByManagerId(userId);
    }
}

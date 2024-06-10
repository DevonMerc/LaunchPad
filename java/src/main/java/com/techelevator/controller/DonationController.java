package com.techelevator.controller;

import com.techelevator.dao.DonationDao;
import com.techelevator.model.Donation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = "/donations")
public class DonationController {
    private DonationDao donationDao;

    public DonationController(DonationDao donationDao) {
        this.donationDao = donationDao;
    }

    @RequestMapping(path = "/campaign/{campaignId}", method = RequestMethod.GET)
    public List<Donation> getDonationsByCampaignId(@PathVariable int campaignId){
        return donationDao.getDonationsByCampaignId(campaignId);
    }

    @RequestMapping(path = "/donor/{donorId}", method = RequestMethod.GET)
    public List<Donation> getDonationsByDonorId(@PathVariable int donorId){
        return donationDao.getDonationsByDonorId(donorId);
    }
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST)
    public Donation createDonation(@RequestBody Donation donation){
        return donationDao.createDonation(donation);
    }
}

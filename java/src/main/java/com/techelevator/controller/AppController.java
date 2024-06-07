package com.techelevator.controller;

import com.techelevator.dao.SpendRequestDao;
import com.techelevator.dao.TagDao;
import com.techelevator.exception.DaoException;
import com.techelevator.model.SpendRequest;
import com.techelevator.model.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@CrossOrigin
public class AppController {
    RestTemplate restTemplate = new RestTemplate();
    private TagDao tagDao;
    private SpendRequestDao spendRequestDao;
    public AppController(TagDao tagDao, SpendRequestDao spendRequestDao){
        this.tagDao = tagDao;
        this.spendRequestDao = spendRequestDao;
    }
    @RequestMapping(path = "/tag", method = RequestMethod.GET)
    public Tag getTagById(int id){
        return tagDao.getTagById(id);
    }
    @RequestMapping(path = "/tags", method = RequestMethod.GET)
    public List<Tag> getTagsByCampaignId(int id){
        return tagDao.getTagsByCampaignId(id);
    }
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/tag", method = RequestMethod.POST)
    public Tag createTag(String tag){
        return tagDao.createTag(tag);
    }
    @RequestMapping(path = "/spend", method = RequestMethod.GET)
    public SpendRequest getSpendRequestById(int id){
        return spendRequestDao.getSpendRequestById(id);
    }
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/spend", method = RequestMethod.POST)
    public SpendRequest createSpendRequest(SpendRequest spendRequest){
        return spendRequestDao.createSpendRequest(spendRequest);
    }
    @RequestMapping(path = "/spend", method = RequestMethod.PUT)
    public boolean updateSpendRequest(SpendRequest spendRequest){
        return spendRequestDao.updateSpendRequest(spendRequest);
    }
    @RequestMapping(path = "/spend-request", method = RequestMethod.GET)
    public List<SpendRequest> getSpendRequestsByCampaignId(int id){
        return spendRequestDao.getSpendRequestsByCampaignId(id);
    }
    @RequestMapping(path = "spend", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTag(int id){
        try{
            tagDao.deleteTag(id);
        }catch (DaoException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tag not found");
        }
    }

    }
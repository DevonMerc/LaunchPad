package com.techelevator.dao;

import com.techelevator.model.Tag;

import java.util.List;

public interface TagDao {
    Tag createTag(String tag);
    Tag getTagById(int id);
    List<Tag> getTagsByCampaignId(int id);
}
package com.techelevator.dao;

import com.techelevator.model.Campaign;
import com.techelevator.model.Tag;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.List;

public class JdbcTagDao implements TagDao{
    private final JdbcTemplate jdbcTemplate;
    public JdbcTagDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Tag createTag(String tag) {
        Tag newTag = null;
        String sql = "INSERT INTO tag(tag_description) VALUES (?) RETURNING tag_id";
        try{
            Integer newTagId = jdbcTemplate.queryForObject(sql, Integer.class,tag);
            if(newTagId != null){
                newTag = getTagById(newTagId);
            }else {
                throw new IllegalStateException("Failed to create campaign.");
            }
        } catch (CannotGetJdbcConnectionException e) {
            System.out.println(e.getMessage());
        } catch (DataIntegrityViolationException e) {
            System.out.println(e.getMessage());
        }
        return newTag;
    }

    @Override
    public Tag getTagById(int id) {
        return null;
    }

    @Override
    public List<Tag> getTagsByCampaignId(int id) {
        return null;
    }

    private Tag mapRowToTag(SqlRowSet rs) {
        Tag tag = new Tag();
        tag.setDescription(rs.getString("tag_description"));
        tag.setId(rs.getInt("tag_id"));
        return tag;
    }

}

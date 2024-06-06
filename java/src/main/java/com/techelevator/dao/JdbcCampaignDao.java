package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Campaign;
import com.techelevator.model.User;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class JdbcCampaignDao implements CampaignDao{

    private final JdbcTemplate jdbcTemplate;
    public JdbcCampaignDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Campaign> getFeaturedCampaigns(){
        List<Campaign> campaigns = new ArrayList<>();

        String sql = "SELECT * FROM campaigns WHERE is_public = true ORDER BY funding LIMIT 7";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {
                Campaign campaign = mapRowToCampaign(results);
                campaigns.add(campaign);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }catch (DataIntegrityViolationException e) {
            System.out.println(e.getMessage());
        }
        return campaigns;
    }

    //wasn't sure if this was for the current user or for searching up a particular managers campaigns, It would be cool to have that searchable as well
    @Override
    public List<Campaign> getCampaignsByManagerId(int id) {
        List<Campaign> campaigns = new ArrayList<>();


        String sql = "SELECT * FROM campaigns WHERE manager_id = ?";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
            while (results.next()) {
                Campaign campaign = mapRowToCampaign(results);
                campaigns.add(campaign);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }catch (DataIntegrityViolationException e) {
            System.out.println(e.getMessage());
        }
        return campaigns;
    }
    @Override
    public List<Campaign> getCampaignsByDonorId(int id) { //confused about this
        List<Campaign> campaigns = new ArrayList<>();


        String sql = "SELECT * FROM campaigns JOIN donations ON campaigns.campaign_id = donations.campaign_id " +
                "WHERE donor_id = ?";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
            while (results.next()) {
                Campaign campaign = mapRowToCampaign(results);
                campaigns.add(campaign);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }catch (DataIntegrityViolationException e) {
            System.out.println(e.getMessage());
        }
        return campaigns;
    }

    @Override
    public List<Campaign> getCampaignsBySearch(String searchTerm) {
        List<Campaign> campaigns = new ArrayList<>();
        searchTerm = '%' + searchTerm + '%';

        String sql = "SELECT * FROM campaigns WHERE description LIKE ? OR title LIKE ?";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, searchTerm, searchTerm);
            while (results.next()) {
                Campaign campaign = mapRowToCampaign(results);
                campaigns.add(campaign);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }catch (DataIntegrityViolationException e) {
            System.out.println(e.getMessage());
        }
        return campaigns;
    }

    @Override
    public Campaign getCampaignById(int id) {
        String sql = "SELECT * FROM campaigns WHERE campaign_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
        if (results.next()) {
            return mapRowToCampaign(results);
        } else {
            return null;
        }
    }

    @Override
    public Campaign createCampaign(Campaign campaign) {
        Campaign newCampaign = null;
        String sql = "INSERT INTO campaigns(title, end_date, goal, manager_id, img_url, funding, visibility, description) VALUES (?,?,?,?,?,?,?, ?) RETURNING campaign_id";
        try{
            Integer newCampaignId = jdbcTemplate.queryForObject(sql, Integer.class, campaign.getTitle(),
                    campaign.getEndDate(), campaign.getGoal(), campaign.getManagerId(), campaign.getImgURL(),
                    campaign.getFunding(), campaign.getisPublic(), campaign.getDescription(), campaign.getId());
            if(newCampaignId != null) {
                newCampaign = getCampaignById(newCampaignId);
            } else {
                throw new IllegalStateException("Failed to create transfer.");
            }
        } catch (CannotGetJdbcConnectionException e) {
            System.out.println(e.getMessage());
        } catch (DataIntegrityViolationException e) {
            System.out.println(e.getMessage());
        }
        return newCampaign;

    }

    @Override
    public boolean updateCampaign(Campaign campaign) {
        Campaign updatedCampaign = null;
        String sql = "UPDATE campaigns SET title = ?, end_date = ?, goal = ?, imgURL = ?, visibility = ?, description = ? WHERE campaign_id = ?";
        jdbcTemplate.update(sql, campaign.getTitle(), campaign.getEndDate(), campaign.getGoal(),
                campaign.getManagerId(), campaign.getImgURL(), campaign.getFunding(),
                campaign.getisPublic(), campaign.getDescription(), campaign.getId());
        updatedCampaign = getCampaignById(campaign.getId());
        if(updatedCampaign!= null){
            return true;
        }
        return false;
    }

    private Campaign mapRowToCampaign(SqlRowSet rs) {
        Campaign campaign = new Campaign();
        campaign.setId(rs.getInt("id"));
        campaign.setTitle(rs.getString("title"));
        if(rs.getDate("end_date").toLocalDate() != null){
            campaign.setEndDate(rs.getDate("end_date").toLocalDate());
        }
        campaign.setGoal(rs.getBigDecimal("goal"));
        campaign.setManagerId(rs.getInt("manager_id"));
        campaign.setImgURL(rs.getString("image_url"));
        campaign.setFunding(rs.getBigDecimal("funding"));
        campaign.setDescription(rs.getString("description"));
        campaign.setisPublic(rs.getBoolean("is_public"));
        return campaign;
    }
}

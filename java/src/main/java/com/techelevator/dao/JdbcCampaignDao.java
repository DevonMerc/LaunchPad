package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Campaign;
import com.techelevator.model.User;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class JdbcCampaignDao implements CampaignDao{

    private final JdbcTemplate jdbcTemplate;
    public JdbcCampaignDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Campaign> getPublicCampaigns(){
        List<Campaign> campaigns = new ArrayList<>();

        String sql = "SELECT * FROM campaigns WHERE visibility = true ORDER BY funding LIMIT 7";
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
    public List<Campaign> getCampaignsByDonorId(int id) {
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
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, searchTerm);
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
    public Campaign createCampaign(String title, LocalDate endDate, BigDecimal goal, int managerId, String imgURL, BigDecimal funding, boolean visibility, String description ) {
        Campaign campaign = null;
        String sql = "INSERT INTO campaigns(title, end_date, goal, manager_id, img_url, funding, visibility, description) VALUES (?,?,?,?,?,?,?, ?) RETURNING campaign_id";
        try{
            Integer newCampaignId = jdbcTemplate.queryForObject(sql, Integer.class, title, endDate, goal, managerId, imgURL, funding, visibility, description);
            if(newCampaignId != null) {
                campaign = getCampaignById(newCampaignId);
            } else {
                throw new IllegalStateException("Failed to create transfer.");
            }
        } catch (CannotGetJdbcConnectionException e) {
            System.out.println(e.getMessage());
        } catch (DataIntegrityViolationException e) {
            System.out.println(e.getMessage());
        }
        return campaign;

    }

    @Override
    public boolean updateCampaign(String title, LocalDate endDate, BigDecimal goal, String imgURL, boolean visibility, String description, int id) {
        Campaign updatedCampaign = null;
        String sql = "UPDATE campaigns SET title = ? end_date = ? goal = ? imgURL = ? visibility = ? description = ? WHERE campaign_id = ?";
        jdbcTemplate.update(sql, title, endDate, goal,imgURL,visibility,description, id);
        updatedCampaign = getCampaignById(id);
        if(updatedCampaign!= null){
            return true;
        }
        return false;
    }

    private Campaign mapRowToCampaign(SqlRowSet rs) {
        Campaign campaign = new Campaign();
        campaign.setCampaignId(rs.getInt("campaign_id"));
        campaign.setTitle(rs.getString("campaign_title"));
//        campaign.setCampaignStartDate(rs.getString("campaign_start_date"));
        campaign.setGoal(rs.getBigDecimal("campaign_goal"));
        campaign.setManagerId(rs.getInt("campaign_owner_id"));
//        campaign.setCampaignImageURL(rs.getString("campaign_image"));
        campaign.setFunding(rs.getBigDecimal("funding_progress"));
        return campaign;
    }
}

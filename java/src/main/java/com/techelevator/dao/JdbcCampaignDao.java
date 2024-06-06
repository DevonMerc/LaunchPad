package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Campaign;
import com.techelevator.model.User;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

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

        //SQL NOT DONE
        String sql = "SELECT * FROM campaigns WHERE ";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {
                Campaign campaign = mapRowToCampaign(results);
                campaigns.add(campaign);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return campaigns;
    }

    @Override
    public List<Campaign> getCampaignsByUserId(int id) {
        return null;
    }

    @Override
    public List<Campaign> getCampaignsBySearch(String searchTerm) {
        return null;
    }

    @Override
    public Campaign getCampaignById(int id) {
        return null;
    }

    @Override
    public Campaign createCampaign(Campaign campaign) {
        return null;
    }

    @Override
    public boolean updateCampaign(int id) {
        return false;
    }

    private Campaign mapRowToCampaign(SqlRowSet rs) {
        Campaign campaign = new Campaign();
        campaign.setCampaignId(rs.getInt("campaign_id"));
        campaign.setCampaignTitle(rs.getString("campaign_title"));
//        campaign.setCampaignStartDate(rs.getString("campaign_start_date"));
        campaign.setCampaignGoal(rs.getBigDecimal("campaign_goal"));
        campaign.setCampaignOwnerId(rs.getInt("campaign_owner_id"));
//        campaign.setCampaignImageURL(rs.getString("campaign_image"));
        campaign.setFundingProgress(rs.getBigDecimal("funding_progress"));
        return campaign;
    }
}

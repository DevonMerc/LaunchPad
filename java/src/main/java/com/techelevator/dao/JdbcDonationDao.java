package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Campaign;
import com.techelevator.model.Donation;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class JdbcDonationDao implements DonationDao{
    private final JdbcTemplate jdbcTemplate;

    public JdbcDonationDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Donation createDonation(BigDecimal amount, int donorId, int campaignId) {
        Donation donation = null;
        String sql = "INSERT INTO campaigns(amount, donorId, campaignId) VALUES (?, ?, ?) RETURNING donation_id";
        try{
            Integer newDonationId = jdbcTemplate.queryForObject(sql, Integer.class, amount, donorId, campaignId);
            if(newDonationId != null) {
                donation = getDonationById(newDonationId);
            } else {
                throw new IllegalStateException("Failed to create transfer.");
            }
        } catch (CannotGetJdbcConnectionException e) {
            System.out.println(e.getMessage());
        } catch (DataIntegrityViolationException e) {
            System.out.println(e.getMessage());
        }
        return donation;
    }

    @Override
    public List<Donation> getDonationsByCampaignId(int id) {
        List<Donation> donations = new ArrayList<>();
        String sql = "SELECT * FROM donation WHERE campaign_id = ?";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
            while (results.next()) {
                Donation donation = mapRowToDonation(results);
                donations.add(donation);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }catch (DataIntegrityViolationException e) {
            System.out.println(e.getMessage());
        }
        return donations;
    }

    @Override
    public List<Donation> getDonationsByDonorId(int id) {
        List<Donation> donations = new ArrayList<>();
        String sql = "SELECT * FROM donation WHERE donor_id = ?";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
            while (results.next()) {
                Donation donation = mapRowToDonation(results);
                donations.add(donation);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }catch (DataIntegrityViolationException e) {
            System.out.println(e.getMessage());
        }
        return donations;
    }
    private Donation mapRowToDonation(SqlRowSet rs){
        Donation donation = new Donation();
        donation.setAmount(rs.getBigDecimal("amount"));
        donation.setCampaignId(rs.getInt("campaign_id"));
        donation.setDonationId(rs.getInt("donation_id"));
        donation.setDonorId(rs.getInt("donor_id"));
        return donation;
    }
}

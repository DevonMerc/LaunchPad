import axios from 'axios';

export default {
  getAllCampaigns() {
    return axios.get('/api/campaigns');
  },

  getFeaturedCampaigns() {
    return axios.get('/api/campaigns/featured');
  },

  createCampaign(campaign) {
    return axios.post('/api/campaigns', campaign);
  }
};


//Centralize all API interactions related to campaigns


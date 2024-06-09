import axios from 'axios';

const baseUrl = axios.create({
  baseURL: "http://localhost:9000"
});

export default {
  // getAllCampaigns() { //idk if we need this
  //   return baseUrl.get('/api/campaigns');
  // },

  getFeaturedCampaigns() {
    return baseUrl.get('/campaigns');
  },

  // getUserCampaigns(){
  //   return baseUrl.get('/campaigns/user-campaigns');
  // },

  //backup plan for get users campaigns
  getUserCampaigns(userId){
    return baseUrl.get(`/campaigns/user-campaigns/${userId}`);
  },

  getCampaignById(campaignId){ 
    return baseUrl.get(`/campaigns/${campaignId}`);
  },

  updateCampaign(campaign, campaignId){
    return baseUrl.put(`/campaigns/${campaignId}`, campaign);
  },
  createCampaign(campaign) { //will need to make this work in frontend later
    return baseUrl.post('/campaigns', campaign);
  }
};


//Centralize all API interactions related to campaigns


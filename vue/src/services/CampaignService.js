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

  getUserCampaigns(){
    return baseUrl.get('/campaigns/user-campaigns');
  },

  getCampaignById(campaignId){ 
    return baseUrl.get(`/campaigns/${campaignId}`);
  },

  updateCampaignById(campaignId){
    return baseUrl.put(`/campaigns/${campaignId}`);
  }
  // createCampaign(campaign) { //will need to make this work in frontend later
  //   return baseUrl.post('/api/campaigns', campaign);
  // }
};


//Centralize all API interactions related to campaigns


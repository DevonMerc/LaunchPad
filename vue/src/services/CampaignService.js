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

  updateCampaign(campaign, campaignId){ //not sure if works yet, other frontend issues getting in the way
    return baseUrl.put(`/campaigns/${campaignId}`, campaign);
  },
  createCampaign(campaign) { 
    return baseUrl.post('/campaigns', campaign);
  },
  deleteCampaign(campaignId){
    return baseUrl.delete(`/campaigns/${campaignId}`);
  },
  searchCampaigns(searchTerm){
    return baseUrl.get(`campaigns/search?searchTerm=${searchTerm}`);
  }
};


//Centralize all API interactions related to campaigns


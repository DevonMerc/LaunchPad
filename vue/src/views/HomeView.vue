<template>
  <!-- CONTENT SHOULD BE GOOD -->
  <div class="home">
    <site-header />
    <body>
      <!-- Testing routing, delete later, things don't show up but I think it's because no data is reachable atm -->
      <div id="nav">
        <router-link v-bind:to="{ name: 'campaignDetails', params: {id: 1} }">Details test</router-link>&nbsp;|&nbsp;
        <router-link v-bind:to="{ name: 'voting' }" v-if="this.$store.state.token != ''">Voting test</router-link>&nbsp;|&nbsp;
        <router-link v-bind:to="{ name: 'view' }" v-if="this.$store.state.token != ''">view test</router-link>&nbsp;|&nbsp;
        <router-link v-bind:to="{ name: 'request' }" v-if="this.$store.state.token != ''">request test</router-link>
      </div>
      <h3>Search For a Campaign</h3>
      <div>
        <input type="text" id="search"  v-model="searchText"/>
        <button @click="search" >Search</button>
      </div>
      
      <button @click="this.$router.push( {name: 'createCampaign'} );">Get Started</button>
      <h3>Browse Featured Campaigns</h3> 
      <div>
        <!-- <campaign-list :campaigns="this.$store.state.campaigns"/> -->
        <!-- router-link should be surrounding cards not list mb -->
        <!-- <campaign-list :campaigns="testCampaigns"/> -->
        <campaign-list :campaigns="featuredCampaigns"/>
      </div>
      
    </body>
    
  </div>
</template>

<script>
import CampaignList from '../components/CampaignList.vue'; 
import SiteHeader from '../components/SiteHeader.vue';
import campaignService from '../services/CampaignService.js';

export default {
  components: {
    SiteHeader,
    CampaignList
  },
  data(){
    return {
      campaigns: [], //not really sure just using this isnt working
    //   isLoading: true
    searchText: ""
    }
  },
  methods: {
    getFeaturedCampaigns() {
      
      campaignService.getFeaturedCampaigns().then(response => {
        this.campaigns = response.data;
        // this.isLoading = false;
      });
    },
    created() { //what does this do again
    this.getFeaturedCampaigns();
  }
  },
  computed: {
    // publicCampaigns(){ //from the fake store data, can delete later
    //   const filteredCampaigns = this.$store.state.campaigns.filter( campaign => {
    //     return campaign.isPublic === true;
    //   });
    //   return filteredCampaigns;
    // },
    featuredCampaigns(){
      this.getFeaturedCampaigns();
      const test = this.campaigns; //for debugging
      return this.campaigns;
    }
    
  }
};
</script>


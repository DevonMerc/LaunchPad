<template>
  <!-- CONTENT SHOULD BE GOOD -->
  <div class="home">
    <site-header />
    <body>
      <!-- {{ this.$store.state.user }} -->
      <!-- Testing routing, delete later, things don't show up but I think it's because no data is reachable atm -->
      <!-- <div id="nav">
        <router-link v-bind:to="{ name: 'campaignDetails', params: {id: 1} }">Details test</router-link>&nbsp;|&nbsp;
        <router-link v-bind:to="{ name: 'voting' }" v-if="this.$store.state.token != ''">Voting test</router-link>&nbsp;|&nbsp;
        <router-link v-bind:to="{ name: 'view' }" v-if="this.$store.state.token != ''">view test</router-link>&nbsp;|&nbsp;
        <router-link v-bind:to="{ name: 'request' }" v-if="this.$store.state.token != ''">request test</router-link>
      </div> -->
      <h3>Search For a Campaign</h3>
      <div>
        <input type="text" id="search"  v-model="searchText"/>
        <button @click="searchCampaigns" >Search</button>
      </div>
      
      <button @click="this.$router.push( {name: 'createCampaign'} );">Get Started</button>
      <h3>Browse Featured Campaigns</h3> 
      <div>
        <campaign-list :campaigns="campaigns" :isDashboard="false"/>
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
      campaigns: [], 
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
    searchCampaigns(){//just doesnt work for some reason, figured it out, somethign with naming conflicts
      campaignService.searchCampaigns(this.searchText).then(response => {
        this.campaigns = response.data;
      });
      console.log(this.searchText);
      console.log(this.campaigns);
    }
  },
  created() { //what does this do again
    this.getFeaturedCampaigns();
  },
  computed: {
    // publicCampaigns(){ //from the fake store data, can delete later
    //   const filteredCampaigns = this.$store.state.campaigns.filter( campaign => {
    //     return campaign.isPublic === true;
    //   });
    //   return filteredCampaigns;
    // },
    // featuredCampaigns(){
    //   this.getFeaturedCampaigns();
    //   const test = this.campaigns; //for debugging
    //   return this.campaigns;
    // }
    
  }
};
</script>


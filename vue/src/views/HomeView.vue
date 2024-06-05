<template>
  <div class="home">
    <site-header />
    <body>
      <h3>Search For a Campaign</h3>
      <div>
        <input type="text" id="search"  v-model="searchText"/>
        <button @click="search" >Search</button>
      </div>
      
      <button @click="this.$router.push( {name: 'createCampaign'} );">Get Started</button>
      <h3>Browse Featured Campaigns</h3> 
      <div>
        <!-- <campaign-list :campaigns="this.$store.state.campaigns"/> -->
        <campaign-list :campaigns="publicCampaigns"/>
      </div>
      
    </body>
    
  </div>
</template>

<script>
import CampaignList from '../components/CampaignList.vue'; 
import SiteHeader from '../components/SiteHeader.vue';
export default {
  components: {
    SiteHeader,
    CampaignList
  },
  methods:{
    
  },
  computed: {
    publicCampaigns(){
      const filteredCampaigns = this.$store.state.campaigns.filter( campaign => {
        return campaign.isPublic === true;
      });
      return filteredCampaigns;
    }
  }
};
</script>


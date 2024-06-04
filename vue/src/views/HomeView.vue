<template>
  <div class="home">
    <site-header />
    <body>
      <h3>Search For a Campaign</h3>
      <div>Some search bar
        <input type="text" id="search"  v-model="searchText"/>
        <button @click="search" >Search</button>
      </div>
      
      <button @click="this.$router.push( {name: 'createCampaign'} );">Get Started</button>
      <h3>Browse Featured Campaigns</h3> 
      <div v-for="card in 5" :key="card">
        <campaign-card/>
      </div>
      
    </body>
    
  </div>
</template>

<script>
import CampaignCard from '../components/CampaignCard.vue'; 
import SiteHeader from '../components/SiteHeader.vue';
export default {
  components: {
    SiteHeader,
    CampaignCard
  },
  methods:{
    
  }
};
</script>


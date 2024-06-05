<template>
    <div class="dashboard">
    <p>You are authenticated if you see this. can delete this later</p>
    <site-header />
    <body>
      <button @click="$router.push( { name: 'createCampaign'} )">Start a new campaign</button>
      <h3>Your Campaigns</h3> 
      <div>
        <campaign-list :campaigns="this.$store.state.campaigns"/>
      </div>
      
    </body>
    
  </div>
</template>

<script>
import CampaignList from '../components/CampaignList.vue'; 
import SiteHeader from '../components/SiteHeader.vue';
export default{
    components: {
        SiteHeader,
        CampaignList
    }
}
</script>
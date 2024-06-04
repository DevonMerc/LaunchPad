<template>
    <div class="dashboard">
    <p>You are authenticated if you see this. can delete this later</p>
    <site-header />
    <body>
      <button @click="$router.push( { name: 'createCampaign'} )">Start a new campaign</button>
      <h3>Your Campaigns</h3> 
      <div v-for="card in 5" :key="card">
        <campaign-card/>
      </div>
      
    </body>
    
  </div>
</template>

<script>
import CampaignCard from '../components/CampaignCard.vue';
import SiteHeader from '../components/SiteHeader.vue';
export default{
    components: {
        SiteHeader,
        CampaignCard
    }
}
</script>
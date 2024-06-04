<template>
  <div class="home">
    <p>You are authenticated if you see this.</p>
    <header>
      <!-- some img/icon
      menu button -> goes to menuview -->
      <h1>LaunchPad</h1>
      <button >Menu</button>
    </header>
    <body>
      <h3>Search For a Campaign</h3>
      <div>Some search bar</div>
      <button>Get Started</button>
      <h3>Browse Featured Campaigns</h3>
      <div v-for="card in 5" :key="card">
        <campaign-card/>
      </div>
      
    </body>
    
  </div>
</template>

<script>
import CampaignCard from '../components/CampaignCard.vue'; 
export default {
  components: {
    CampaignCard
  }
};
</script>

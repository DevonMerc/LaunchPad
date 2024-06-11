<template>
  <div class="campaign-page">
    <SiteHeader />
    <div class="logo-container" v-if="campaign.imgURL">
      <img class="logo" src="../assets/Launchpad-logo-full.png" alt="Place Holder">
    </div>

    <div class="container">
      <h1 class="title">{{ campaign.title }}</h1>
      <h2 class="subtitle">Fund this Project!</h2>
      <p class="organizer">Organizer: {{ campaign.managerId }}</p>
      <p class="goal">Goal: {{ campaign.goal }}</p>
      <p class="description">{{ campaign.description }}</p>
      <p class="funding">${{ campaign.funding }} raised out of our ${{ campaign.goal }} GOAL!</p>
      <button class="donate-button" @click="this.$router.push({name: 'donationForm', params:{campaignId:campaign.campaignId}})">Donate</button>
      <p class="timeline">Timeline: {{ daysLeft }} Days Left!</p>
      <p class="donation-info">If {{ requiredDonors }} people donate ${{ donationAmount }}, the campaign will be over.</p>
      <!-- <p class="campaign-impact">For every $Y the campaign will be able to Z(Whatever the campaign is for)</p> -->
      <h1 class="donors-title">Thank You To Our Donors!</h1>
      <p class="top-donors">Top Donors:</p>
      <!-- <p>We need to figure out how to parse this info now, and shorten amount of donations shown</p> -->
      <div v-for="donation in donations" :key="donation.donationId" class="donation">
        <p>{{ donation }}</p>
      </div>
      <!-- <h2 class="breakdown-title">Donation Breakdown:  X% of Money on: Placeholder | X% of Money on: Placeholder | X% of Money on: Placeholder</h2>
      <progress id="item1Spend" :value="progressValue" max="100">{{progressValue}}%</progress>
      <progress id="item2Spend" :value="progressValue" max="100">{{progressValue}}%</progress>
      <progress id="item3Spend" :value="progressValue" max="100">{{progressValue}}%</progress> -->
    </div>
  </div>
</template>
  
<script>
import { mapGetters } from 'vuex';
import campaignService from '../services/CampaignService';

export default {
  props: ['campaign', 'campaignId'], //bc of timing BUGS adding in campaignId to props, campaign is null in JS despite having data accessible in html
  data(){
    return{
      donations: []
    }
  },
  computed: {
    // ...mapGetters(['campaign']),
    daysLeft() {
      if (!this.campaign.endDate) {
        return '';
      }
      const targetDate = new Date(this.campaign.endDate);
      const currentDate = new Date();
      const timeDifference = targetDate - currentDate;
      const daysLeft = Math.ceil(timeDifference / (1000 * 60 * 60 * 24));
      if (daysLeft > 0) {
        return daysLeft;
      } else if (daysLeft === 0) {
        return 'Today!';
      } else {
        return 'This date has passed.';
      }
    },
    progressValue() {
      if (!this.campaign.goal || !this.campaign.funding) {
        return 0;
      }
      return Math.min((this.campaign.funding / this.campaign.goal) * 100, 100);
    },
    requiredDonors() {
      const amountNeeded = this.campaign.goal - this.campaign.funding;
      if (amountNeeded <= 0) {
        return 0;
      }
      return Math.ceil(amountNeeded / this.donationAmount);
    },
    donationAmount() {
      const baseDonation = 5;
      const increment = 5;
      let dynamicDonation = baseDonation;
      
      while ((this.campaign.goal / dynamicDonation) > 1000 && dynamicDonation < 100) {
        dynamicDonation += increment;
      }
      
      return dynamicDonation;
    }
    // donations(){
    //   campaignService.getDonationsByCampaignId(this.campaign.campaignId).then(response => {
    //     if(response.status === 200){
    //       return response.data;
    //     }
    //   });
    //   return {};
    // }
  },
  created(){
    campaignService.getDonationsByCampaignId(this.campaignId).then(response => {
      if(response.status === 200){
        console.log(response.data);
        this.donations = response.data;
        console.log(this.donations);
      }
    });
  }
  // methods: {
  //   donate(){

  //   }
  // }
};
</script>

<style scoped>
.campaign-page {
  display: flex;
  flex-direction: column;
  align-items: center;
  padding: 6.5rem 3rem 20px; /* Add top padding to make room for fixed header */
  background-color: #f9f9f9;
  font-family: Arial, sans-serif;
}

.logo-container {
  margin-bottom: 20px;
}

.logo {
  width: 150px;
  border-radius: 15px;
}

.container {
  background: white;
  padding: 2.2rem;
  border-radius: 10px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
  width: 100%;
  max-width: 800px;
  margin-top: 20px; /* Add margin to prevent overlap with header */
}

.title {
  font-size: 2em;
  color: #333;
}

.subtitle {
  font-size: 1.5em;
  color: #666;
}

.organizer, .goal, .description, .funding, .timeline, .donation-info, .campaign-impact, .top-donors, .breakdown-title {
  font-size: 1em;
  margin: 10px 0;
  color: #444;
  font-style: italic;
  font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
}

.donate-button {
  background-color: #4CAF50;
  color: white;
  padding: 10px 20px;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  margin: 10px 0;
  font-size: 1em;
}

.donate-button:hover {
  background-color: #45a049;
}

.donors-title {
  font-size: 1.5em;
  margin-top: 20px;
  color: #333;
}

.donation {
  background: #f1f1f1;
  padding: 10px;
  border-radius: 5px;
  margin: 5px 0;
}

progress {
  width: 100%;
  margin: 10px 0;
}
</style>

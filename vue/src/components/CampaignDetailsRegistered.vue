<template>
    <!-- <div v-if="campaign.imgURL"> -->
        <img src="../assets/PLACEHOLDER_LOGO.png" alt="Place Holder">
    <!-- </div> -->
    <div class="container">

        <h1>{{ campaign.title }}</h1>
        <h2>Fund this Project!</h2>
        <p>Organizer:{{ campaign.managerId }}</p>
        <p>Goal: {{ campaign.goal }}</p>
        <p>Description: {{ campaign.description }}</p>
        
        <p>${{ campaign.funding }} RAISED OUT OF {{ campaign.goal }} GOAL!</p>

        <button @click="this.$router.push({name: 'donationForm', params:{campaignId:campaign.campaignId}})">Donate</button>

        <p>Timeline: {{ daysLeft }} Days Left!</p>

        <p>If {{ requiredDonors }} people donate ${{ donationAmount }}, the campaign will be over.</p>

        <p>For every $Y the campaign will be able to Z(Whatever the campaign is for)</p>

        <h1> Thank You To Our Donors </h1>
        <p>Top Donors: </p>

        <div v-for="donation in donations.slice(0,5)" :key="donation.donationId">
          <!-- {{ donation }} -->
          <p>Donor {{ donation.donorId }} donated ${{ donation.amount }} on {{donationDateTime(donation.dateTime) }}</p>
        </div>

        <h2>Donation Breakdown:  X% of Money on: Placeholder | X% of Money on: Placeholder | X% of Money on: Placeholder</h2>
        <progress id="item1Spend" :value="progressValue" max="100">{{progressValue}}%</progress>
        <progress id="item1Spend" :value="progressValue" max="100">{{progressValue}}%</progress>
        <progress id="item1Spend" :value="progressValue" max="100">{{progressValue}}%</progress>

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
  methods: {
    donationDateTime(dateTime){
      const timestamp = new Date(dateTime);
      //.toLocaleDateString is a built in function for converting timestamp day info to weekday word, month word ect eg. 10 => October
      return `${timestamp.toLocaleDateString('en-US', { weekday: 'long' })}, ${timestamp.toLocaleDateString('en-US', { month: 'long' })} ${this.dayWithSuffix(timestamp.getDate())} ${timestamp.getFullYear()}`;
    },
    dayWithSuffix(day){ //for getting stuff like 1st, 2nd, 11th ect.
      if(day === 11 || day === 12 || day === 13){
        return `${day}th`;
      }else{
        const onesDigit = day % 10;
        if(onesDigit === 1){
          return `${day}st`;
        }else if(onesDigit === 2){
          return `${day}nd`;
        }else if(onesDigit === 3){
          return `${day}rd`;
        }else{
          return `${day}th`;
        }
      }
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
  },
  created(){
    campaignService.getDonationsByCampaignId(this.campaignId).then(response => {
      if(response.status === 200){
        this.donations = response.data;
      }
    });
  }
};
</script>
  
<style>
</style>
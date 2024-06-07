<template>
    <button>menu</button>

    <div v-if="campaign.pic">
        <img src="../assets/PLACEHOLDER_LOGO.png" alt="Place Holder">
    </div>
    <div class="container">

        <h1>{{ campaign.title }}</h1>
        <h2>Fund this Project!</h2>
        <p>Organizer:{{ campaign.organizer }}</p>
        <p>Goal: {{ campaign.goal }}</p>
        <p>Description: {{ campaign.about }}</p>
        
        <p>$<!--Need Donation Raised amount--> RAISED OUT OF {{ campaign.goal }} GOAL!</p>

        <button>Donate</button>

        <p>Timeline: {{ daysLeft }} Days Left!</p>

        <p>If {{ requiredDonors }} people donate ${{ donationAmount }}, the campaign will be over.</p>

        <p>For every $Y the campaign will be able to Z(Whatever the campaign is for)</p>

        <h1> Thank You To Our Donors </h1>
        <p>Top Donors: </p>

        <p>1. Placeholder for donor 1</p>
        <p>2. Placeholder for donor 2</p>
        <p>3. Placeholder for donor 3</p>

        <h2>Donation Breakdown:  X% of Money on: Placeholder | X% of Money on: Placeholder | X% of Money on: Placeholder</h2>
        <progress id="item1Spend" :value="progressValue" max="100">{{progressValue}}%</progress>
        <progress id="item1Spend" :value="progressValue" max="100">{{progressValue}}%</progress>
        <progress id="item1Spend" :value="progressValue" max="100">{{progressValue}}%</progress>

    </div>
</template>
  
<script>
import { mapGetters } from 'vuex';

export default {
  computed: {
    ...mapGetters(['campaign']),
    daysLeft() {
      if (!this.campaign.timeline) {
        return '';
      }
      const targetDate = new Date(this.campaign.timeline);
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
      if (!this.campaign.goal || !this.campaign.raisedAmount) {
        return 0;
      }
      return Math.min((this.campaign.raisedAmount / this.campaign.goal) * 100, 100);
    },
    requiredDonors() {
      const amountNeeded = this.campaign.goal - this.campaign.raisedAmount;
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
  }
};
</script>
  
<style>
</style>
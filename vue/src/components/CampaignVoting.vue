<template>
    <div v-if="campaign.pic">
        <img src="../assets/Launchpad-logo-full.png" alt="Place Holder">
    </div>
    <div>
        <h1>Completed Campaign</h1>
    </div>
    <div v-if="campaign.pic">
        <img src="../assets/PLACEHOLDER_LOGO.png" alt="Place Holder">
    </div>
    <div class="container">
        <h1>Place Holder for Campaign Organizer Request</h1>
        <!--I will connect these to the campaign request form once we've made it-->
        <h2>Place Holder for more information about Campaign Organizer Request</h2>
        <!--I will connect these to the campaign request form once we've made it-->
    </div>
    <div class="voting-container">
        <label class="voting-option">
            <input type="radio" name="vote" value="yes">
            <img src="../assets/thumbsup.png" alt="Yes">
            <span>Yes</span>
        </label>
        <label class="voting-option">
            <input type="radio" name="vote" value="no">
            <img src="../assets/thumbsdown.png" alt="No">
            <span>No</span>
        </label>
        <progress id="voteYes" value="70" max="100">70%</progress>
        <progress id="voteNo" value="30" max="100">30%</progress>
    </div>
</template>
  
  <script>
  import { mapGetters } from 'vuex';
  
  export default {
    computed: {
      ...mapGetters(['campaign'])
    }
  };
  </script>
  
<style>
</style>
<template>

    <!-- <button>Menu</button> -->
    <div class="container">
      <img src="../assets/PLACEHOLDER_LOGO.png" alt="Place Holder">
      <h1>{{ campaign.title }}</h1>
      <p>Goal: {{ campaign.goal }}</p>
      <p>Description: {{ campaign.description }}</p>
      <!-- <p>Visibility: {{ campaign.isPublic }}</p> -->
      <!-- Commenting vvv out for now bc we don't have images figured out -->
      <!-- <div v-if="campaign.imgURL">
        <img src="../assets/PLACEHOLDER_LOGO.png" alt="Place Holder">
      </div> -->
    </div>
  </template>
  
  <script>
  // import { mapGetters } from 'vuex';
  
  export default {
    props: ['campaign'],
    computed: {
      // ...mapGetters(['campaign'])
    }
  };
  </script>
  
<style>
</style>
  
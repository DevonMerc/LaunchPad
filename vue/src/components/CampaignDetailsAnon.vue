<template>
    <div class="container">
      <h1>{{ campaign.title }}</h1>
      <p>Goal: {{ campaign.goal }}</p>
      <p>Description: {{ campaign.about }}</p>
      <p>Visibility: {{ campaign.visibility }}</p>
      <div v-if="campaign.pic">
        <img src="../assets/PLACEHOLDER_LOGO.png" alt="Place Holder">
      </div>
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
  
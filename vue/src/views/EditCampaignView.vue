<template>
    <!-- STILL NEEDS WORK -->
    <!-- <div class="loading" v-if="isLoading">
      <p>Loading...</p>
    </div>
    <div v-else> -->
      <h1>Edit Campaign</h1>
      <campaign-form v-bind:campaign="campaign" />
    <!-- </div> -->
  </template>
  
  <script>
  
  import campaignService from '../services/CampaignService';
  import CampaignForm from '../components/CampaignForm.vue';
  
  export default {
    components: {
        CampaignForm
    },
    data() {
      return {
        campaign: {}
        // isLoading: true
      }
    },
    methods: {
        //below still needs work, need to create some more views...
      getCampaign(id) {
        campaignService.getCampaignById(id)
          .then(response => {
            this.campaign = response.data;
            // this.isLoading = false;
          })
          .catch(error => {
            if (error.response) {
              if (error.response.status == 404) {
                this.$router.push({name: 'NotFoundView'});
              } 
              else {
                this.$store.commit('SET_NOTIFICATION',
                `Error getting message. Response received was "${error.response.statusText}".`);
              }
            } else if (error.request) {
              this.$store.commit('SET_NOTIFICATION', `Error getting message. Server could not be reached.`);
            } else {
              this.$store.commit('SET_NOTIFICATION', `Error getting message. Request could not be created.`);
            }
          })
      }
    },
    created() {
      this.getCampaign(this.$route.params.campaignId);
    } 
  };
  </script>
  
  <style scoped>
  </style>
  
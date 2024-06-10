<template>
    <!-- STILL NEEDS WORK -->
    <!-- <div class="loading" v-if="isLoading">
      <p>Loading...</p>
    </div>
    <div v-else> -->
      <h1>Edit Campaign</h1>
      <campaign-form :campaign="campaign" ref="editForm" />
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
        //I did this in a wacky way, can move method content into created(), refactor later if there's time
      getCampaign(id) {
        campaignService.getCampaignById(id)
          .then(response => {
            this.campaign = response.data;
            this.$refs.editForm.updateFormData();
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
      let campaignId = parseInt(this.$route.params.id);
      // this.getCampaign(campaignId);
      campaignService.getCampaignById(campaignId)
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
    },
    computed: { //don't really need this was just testing things
      testCampaign(){
        this.getCampaign(this.$route.params.id);
        return this.campaign;
      }
    }
  };
  </script>
  
  <style scoped>
  </style>
  
<template>
    <!-- Connection works -->
    <SiteHeader />
    <!-- <div>{{ isUserAnon }}, {{ isUserRegistered }}</div> -->
    <!-- I think this was meant to be the component not the view, so changed the names -->
    <!-- <CampaignDetailsAnonView /> -->
    <CampaignDetailsAnon v-if="isUserAnon" :campaign="campaign" />
    <CampaignDetailsRegistered v-if="isUserRegistered" :campaign="campaign" />
</template>


<script>
// import CampaignDetailsAnonView from '../components/CampaignDetailsForm.vue';
import CampaignDetailsAnon from '../components/CampaignDetailsAnon.vue';
import SiteHeader from '../components/SiteHeader.vue';
import campaignService from '../services/CampaignService.js';
import CampaignDetailsRegistered from '../components/CampaignDetailsRegistered.vue';
export default{
    
    components: {
        // CampaignDetailsAnonView,
        CampaignDetailsAnon,
        CampaignDetailsRegistered,
        SiteHeader
    },
    data() {
        return {
            campaign: {
                campaignId: 0,
                title: "",
                endDate: '0000-00-00',
                goal: 0.00,
                managerId: 0,
                imgURL: "",
                funding: 0.00,
                description: "",
                isPublic: false
            }
            // isLoading: true
        };
    },
    computed: {
        isUserAnon(){
            return JSON.stringify(this.$store.state.user) === "{}";
        },
        isUserRegistered(){
            return JSON.stringify(this.$store.state.user) != "{}";
        }
    },
    created() {
      const id = this.$route.params.id; //for debugging
      campaignService
      .getCampaignById(this.$route.params.id)
      .then(response => {
        this.campaign = response.data;
        // this.isLoading = false;
      });
  }
}
</script>


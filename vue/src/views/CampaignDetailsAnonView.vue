<template>
    <!-- Connection works -->
    <SiteHeader />
    <!-- I think this was meant to be the component not the view, so changed the names -->
    <!-- <CampaignDetailsAnonView /> -->
    <CampaignDetailsAnon :campaign="campaign"/>
</template>


<script>
// import CampaignDetailsAnonView from '../components/CampaignDetailsForm.vue';
import CampaignDetailsAnon from '../components/CampaignDetailsAnon.vue';
import SiteHeader from '../components/SiteHeader.vue';
import campaignService from '../services/CampaignService.js';
export default{
    
    components: {
        // CampaignDetailsAnonView,
        CampaignDetailsAnon,
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


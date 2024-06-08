<!-- add header here  -->
<template>
    <!-- SHOULD BE OK -->
    <site-header />
    <campaign-form :campaign="campaign"/>
</template>

<script>
import CampaignForm from '../components/CampaignForm.vue';
import SiteHeader from '../components/SiteHeader.vue';

export default{
    components: {
        CampaignForm,
        SiteHeader
    },
    data(){
        return{
            campaign: {
                campaignId: 0,
                title: this.campaign.title,
                endDate: '0000-00-00',
                goal: 0.00,
                managerId: 0,
                imgURL: "",
                funding: 0.00,
                description: "",
                isPublic: false
            }
        }
    }
}
</script>

<!-- add header here  -->
<template>
    <div>
    <!-- SHOULD BE OK -->
    <site-header />
    <campaign-form :campaign="campaign"/>
    </div>
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
                title: "",
                endDate: "",
                goal: "",
                managerId: "",
                imgURL: "",
                funding: "",
                description: "",
                isPublic: false
            }
        }
    }
}
</script>

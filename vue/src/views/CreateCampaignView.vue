<!-- add header here  -->
<template>
    <site-header />
    <body>
        <!-- SHOULD BE OK -->
        
        <h1 class="campaign-form-h1">Create a campaign</h1>
        <div class="loading" v-if="isLoading">
            <p>Loading...</p>
        </div>
        <campaign-form :campaign="campaign"/>
    </body>
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

<style scoped>
body{
    margin: .7rem;
}
</style>

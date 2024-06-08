<template>
    <div class="campaign-card" v-for="campaign in campaigns" :key="campaign.id">
        <!-- <router-link v-bind:to="{ name: 'campaignDetails', params: {id: campaign.id} }"> -->
            <campaign-card :campaign="campaign"/>
        <!-- </router-link> -->
    </div>
</template>

<script>
import CampaignCard from '../components/CampaignCard.vue';
export default{
    components: {
        CampaignCard
    },
    props: ['campaigns'] //I have campaigns coming in as a prop bc the campaigns depends on the page, anon vs registered
}
</script>
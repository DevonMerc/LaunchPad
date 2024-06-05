<template>
    <div class="campaign-card">
        <campaign-card v-for="campaign in campaigns" :key="campaign.id" :campaign="campaign"/>
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
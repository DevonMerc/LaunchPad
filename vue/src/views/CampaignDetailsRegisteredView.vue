<site-header />
<template>
    <SiteHeader />
    <CampaignDetailsRegistered />
</template>

<script>
import CampaignDetailsRegistered from '../components/CampaignVoting.vue';
import SiteHeader from '../components/SiteHeader.vue';


export default{
    components: {
    CampaignDetailsRegistered,
    SiteHeader
},

}
</script>

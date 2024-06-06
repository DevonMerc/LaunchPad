<site-header />
<template>
    <SiteHeader />
    <CampaignDetailsAnonView />
</template>

<script>

import CampaignDetailsAnonView from '../components/CampaignForm.vue';
import SiteHeader from '../components/SiteHeader.vue';

export default{
    components: {
        CampaignDetailsAnonView,
        SiteHeader
    }
}
</script>


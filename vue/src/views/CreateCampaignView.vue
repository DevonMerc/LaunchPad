<!-- add header here  -->
<site-header />
<template>
    <campaign-form/>
</template>

<script>
import CampaignForm from '../components/CampaignForm.vue';
import SiteHeader from '../components/SiteHeader.vue';

export default{
    components: {
        CampaignForm
    },
    data(){
        //dunno if well need this but whatever
    }
}
</script>

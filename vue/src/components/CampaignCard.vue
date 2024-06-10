<template>
    <!-- NEED TO SHOW BUTTONS WHEN ITS DASHBOARD -->
    <div class = "card">
        <router-link v-bind:to="{ name: 'campaignDetails', params: {id: campaign.campaignId} }">
            <img src="../assets/PLACEHOLDER_LOGO.png"/>
        </router-link>

        <div class="info">
        <p>{{ campaign.title }}</p>
        <p>Manged by {{ campaign.managerId }}</p>
        <p>{{ campaign.description }}</p>
        <p>${{ campaign.funding }}/${{ campaign.goal }} Currently raised</p>
        <!-- <button  @click="$router.push({name: 'campaignDetails', params: {id: campaign.campaignId}})">View Details</button> -->
        <div v-show="isDashboard">
            <button @click="$router.push({name: 'editCampaign', params: {id: campaign.campaignId}})">Edit Campaign</button>
            <!-- Add click event later vvv -->
            <button @click="deleteCampaign">Delete Campaign</button>
        </div>
        <!-- <p>Tags</p>
        <div class="tags" v-for="tag in campaign.tags" :key="tag">
            <p>{{ tag }}</p>
        </div> -->
        </div>
    </div> 

</template>

<script>
import campaignService from '../services/CampaignService.js';
export default{
    
    props: ['campaign', 'isDashboard'],
    methods: {
        deleteCampaign() { // for now shouldn't work, uncomment and work on after endpoint is set
            // if(true){//we need to be able to get donors associated with a campaign id

            // }else{
                if (confirm("Are you sure you want to delete this campaign? This action cannot be undone.")) {
                campaignService.deleteCampaign(this.campaign.campaignId).then(response => {
                    if (response.status === 204) {
                        this.$store.commit(
                            'SET_NOTIFICATION',
                            {
                                message: `Campaign "${this.campaign.title}" was successfully deleted.`,
                                type: 'success'
                            }
                        );
                        this.$router.push({ name: 'dashboard'});
                        // this.$router.go(0);
                    }
                })
                .catch(error => {
                    if (error.response) {
                        this.$store.commit('SET_NOTIFICATION',
                        `Error deleting campaign. Response received was "${error.response.statusText}".`);
                    } else if (error.request) {
                        this.$store.commit('SET_NOTIFICATION', 'Error deleting campaign. Server could not be reached.');
                    } else {
                        this.$store.commit('SET_NOTIFICATION', 'Error deleting campaign. Request could not be created.');
                    }
                });
            // }
            }
            
        }
    }
}
</script>

<style scoped>
body{
    padding: 0;
}
.card {
  border: 2px solid black;
  border-radius: 10px;
  width: 80%;
  height: auto;
  margin: 20px;
  position: relative;
  display: flex;
  flex-direction: row;

}
.card img{
    width: 50%;
    height: 50%;
}
/* .tags{
    display: flex;
    flex-direction: row;
} */
</style>
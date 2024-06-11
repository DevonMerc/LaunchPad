<template>
    <!-- NEED TO SHOW BUTTONS WHEN ITS DASHBOARD -->
    <div class = "card">
      
        <router-link v-bind:to="{ name: 'campaignDetails', params: { id: campaign.campaignId } }" class="card-image">
          <img src="../assets/Launchpad-logo.png" alt="Campaign Image" />
        </router-link>


        <div class="info">

        <p class="title">{{ campaign.title }}</p>
        <p class="manager">Managed by {{ campaign.managerId }}</p>
        <p class="description">{{ campaign.description }}</p>
        <p class="funding">${{ campaign.funding }} / ${{ campaign.goal }} Currently raised</p>

        <!-- <button  @click="$router.push({name: 'campaignDetails', params: {id: campaign.campaignId}})">View Details</button> -->
        <div v-show="isDashboard" class="dashboard-buttons">
            <button @click="$router.push({ name: 'editCampaign', params: { id: campaign.campaignId } })">Edit Campaign</button>
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
body {
  padding: 0;
}

.card {
  border: 2px solid rgb(194, 192, 192);
  border-radius: 10px;
  width: 100%;
  margin: 20px auto;
  display: flex;
  flex-direction: row;
  background-color: #fff;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
  height: 200px; /* Standard height for all cards */
}

.card-image {
  width: 40%;
}

.card-image img {
  width: 100%;
  height: auto;
  object-fit: cover; /* Ensure the image covers the entire area */
}

.info {
  width: 60%;
  padding: 0.5rem; /* Reduced padding */
  display: flex;
  flex-direction: column;
  justify-content: flex-start;
  align-items: flex-start;
}

.title,
.manager,
.description,
.funding {
  margin: 0; /* Remove default margin */
  padding: 0.25rem 0; /* Add small padding for spacing */
  font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
  font-size: 0.8rem;
  font-style: oblique;
}

.title {
    font-weight: bolder;
    font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
}

.dashboard-buttons {
  display: flex;
  justify-content: space-around;
  margin-top: 0.5rem; /* Adjust margin for spacing */
}

.dashboard-buttons button {
  padding: 0.5rem 1rem;
  font-size: 1rem;
  background-color: #007bff;
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  flex: 1;
  margin: 0 0.5rem;
}

.dashboard-buttons button:last-child {
  background-color: #dc3545;
}

@media (min-width: 600px) {
  .card {
    height: 200px; /* Maintain the same height for larger screens */
  }
}
</style>
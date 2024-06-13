<template>
    <!-- NEED TO SHOW BUTTONS WHEN ITS DASHBOARD -->
    <div class = "card">
      
        <router-link v-bind:to="{ name: 'campaignDetails', params: { id: campaign.campaignId } }" class="card-image">
          <!-- <img src="../assets/Launchpad-logo.png" alt="Campaign Image" /> -->
          
          <img :src="getRandomImage()" alt="Campaign Image" />
          <!-- <img data-v-7377613c="" src="../assets/campaignPictures/clothes.jpg" alt="Campaign Image"> -->
        </router-link>


        <div class="info">
        <p v-if="errorMsg != ''">{{ errorMsg }}</p>
        <p class="title">{{ campaign.title }}</p>
        <p class="manager">Managed by {{ managerName }}</p>
        <p class="description">{{ campaign.description }}</p>
        <ProgressBar :funding="campaign.funding" :goal="campaign.goal"/>
        <p class="funding">${{ campaign.funding }} / ${{ campaign.goal }} Currently raised</p>

        <!-- <button  @click="$router.push({name: 'campaignDetails', params: {id: campaign.campaignId}})">View Details</button> -->
        <div v-show="isDashboard" class="dashboard-buttons">
            <button @click="$router.push({ name: 'editCampaign', params: { id: campaign.campaignId } })">Edit Campaign</button>
            <!-- Add click event later vvv -->
            <button @click="deleteCampaign">Delete Campaign</button>
            <router-link to="/create-spend-request" class="button-link">Create Spend Request</router-link>
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
import ProgressBar from './ProgressBar.vue';

export default {
  components: {
    ProgressBar
  },
  data() {
    return {
      errorMsg: '',
      donations: [],
      managerName: 'N/A',
      campaignImage: '',
  
    };
  },
  props: ['campaign', 'isDashboard'],
  methods: {
    deleteCampaign() { // for now shouldn't work, uncomment and work on after endpoint is set
      const donations = this.donations;
      console.log(donations.length);
      if (donations.length > 0) { //we need to be able to get donors associated with a campaign id
        this.errorMsg = 'Cannot delete campaign';
        this.$store.commit('SET_NOTIFICATION', 'Cannot delete campaigns that have donors!');
      } else {
        if (confirm("Are you sure you want to delete this campaign? This action cannot be undone.")) {
          campaignService.deleteCampaign(this.campaign.campaignId).then(response => {
            if (response.status === 204) {
              this.$emit('delete-complete');
            }
          })
          .catch(error => {
            if (error.response) {
              this.$store.commit('SET_NOTIFICATION', `Error deleting campaign. Response received was "${error.response.statusText}".`);
            } else if (error.request) {
              this.$store.commit('SET_NOTIFICATION', 'Error deleting campaign. Server could not be reached.');
            } else {
              this.$store.commit('SET_NOTIFICATION', 'Error deleting campaign. Request could not be created.');
            }
          });
        }
      }
    },
    getDonations() {
      campaignService.getDonationsByCampaignId(this.campaign.campaignId).then(response => {
        if (response.status === 200) {
          this.donations = response.data;
        }
      });
      return [];
    },
    getRandomImage() {
      
      const images = [
        '../../public/campaignPictures/school.jpg',
        '../../public/campaignPictures/art.jpg',
        '../../public/campaignPictures/clothes.jpg',
        '../../public/campaignPictures/elephants.jpg',
        '../../public/campaignPictures/food.jpg',
        '../../public/campaignPictures/medicalsupplies.jpg',
        '../../public/campaignPictures/waterwell.jpg',
      ];
      const randomIndex = Math.floor(Math.random() * images.length);
      console.log(images[randomIndex]);
      return images[randomIndex];
    }
  },
  created() {
    campaignService.getDonationsByCampaignId(this.campaign.campaignId).then(response => {
      if (response.status === 200) {
        this.donations = response.data;
      }
    });

    campaignService.getUsernameByManagerId(this.campaign.managerId).then(response => {
      if (response.status === 200) {
        this.managerName = response.data;
      }
    });

    // Set a random campaign image
    this.campaignImage = this.getRandomImage();
  }
};
</script>



<!-- The line script file below this line is the original script file.  -->

<!-- <script>
import campaignService from '../services/CampaignService.js';
import ProgressBar from './ProgressBar.vue';
export default{
    components: {
      ProgressBar
    },
    data(){
      return{
        errorMsg: '',
        donations : [],
        managerName: 'N/A'
      }
    },
    props: ['campaign', 'isDashboard'],
    methods: {
        deleteCampaign() { // for now shouldn't work, uncomment and work on after endpoint is set
        const donations = this.donations;
        console.log(donations.length);
            if(donations.length > 0){//we need to be able to get donors associated with a campaign id
              this.errorMsg = 'Cannot delete campaign';
              this.$store.commit(
                  'SET_NOTIFICATION', 'Cannot delete campaigns that have donors!');
            }else{
                if (confirm("Are you sure you want to delete this campaign? This action cannot be undone.")) {
                campaignService.deleteCampaign(this.campaign.campaignId).then(response => {
                    if (response.status === 204) {
                        // this.$router.push({ name: "dashboard"});
                        
                        this.$emit('delete-complete');
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
            }
            }
            
        },
        getDonations(){
          campaignService.getDonationsByCampaignId(this.campaign.campaignId).then(response => {
            if(response.status === 200){
              this.donations = response.data;
            }
          });
          return [];
        }
    }, 
    created() {
      campaignService.getDonationsByCampaignId(this.campaign.campaignId).then(response => {
            if(response.status === 200){
              this.donations = response.data;
            }
          });

      campaignService.getUsernameByManagerId(this.campaign.managerId).then(response => {
        if(response.status === 200){
          this.managerName = response.data;
        }
      })
    }
}
</script>  -->

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
  width: 30%;
}

.card-image img {
  width: 100%;
  height: auto;
  object-fit: cover; /* Ensure the image covers the entire area */
}

.info {
  width: 70%;
  padding: 0.5rem; /* Reduced padding */
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  align-items: flex-start;
}

.title,
.manager,
.description,
.funding {
  margin: 0; /* Remove default margin */
  padding: 0.25rem 0; /* Add small padding for spacing */
  font-family: sans-serif,'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;
  font-size: 0.8rem;
  font-style: oblique;
}

.title {
    font-weight: bolder;
    font-family: sans-serif,'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;
}

.dashboard-buttons {
  display: flex;
  justify-content: space-around;
  margin-top: 0.5rem; /* Adjust margin for spacing */
  width: 100%;
}

/* .dashboard-buttons button {
  padding: 0.5rem 1rem;
  font-size: 1rem;
  background-color: #007bff;
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  flex: 1;
  margin: 0 0.05rem;
} */

.dashboard-buttons button,
.dashboard-buttons .button-link {
  padding: 0.5rem 1rem;
  font-size: 1rem;
  background-color: #007bff;
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  flex: 1; 
  margin: 0 0.07rem; 
  text-align: center; 
  text-decoration: none; 
  display: inline-block; 
}

.dashboard-buttons .button-link:hover {
  background-color: #0056b3; /* Add hover effect */
}
.dashboard-buttons button:last-child {
  background-color: #007BFF;
  color: white;
}

@media (min-width: 600px) {
  .card {
    height: 200px; /* Maintain the same height for larger screens */
  }
}
</style>
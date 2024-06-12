<template>
    <!-- STILL NEEDS WORK -->
    <!-- <div>
        <h1>My unorthodox below, form not finished</h1>
        Thinking a form:
        $ Goal
        Title
        Campaign manager
        Description
        image upload maybe
        radio button for private or public
        dropdown menu for tags set, or its like checkboxes? Gonna struggle with checkbox logic
        submit button
    </div> -->
    <div class="container">
      <!-- We probably dont need the @submit in the form tag but this works so not gonna touch it now -->
    <form @submit.prevent="addCampaign">
        <div>
            <label for="title" class="grey">What will you call your campaign? </label>
            <input type="text" id="title"  required v-model="editedCampaign.title" />
        </div>
        <div>
            <label for="managerId" class="grey">Campaign Organizer</label>
            <input type="text" id="managerId" required v-model="editedCampaign.managerId"/>
        </div>
        <div>
            <label for="goal" class="grey">What is your starting goal? </label>
            <input type="number" id="goal" required v-model="editedCampaign.goal"/>
        </div>
        <div>
            <label for="description" class="grey">Describe your campaign: </label>
            <textarea id="description" rows="6" cols="50" required v-model="editedCampaign.description"></textarea>
        </div>
        <div>
            <label for="imgURL">Upload an image: </label>
            <input type="file" id="imgURL" accept="image/*" :src="editedCampaign.imgURL"/>
        </div>
        <div>
            <label for="endDate" class="form-label">When will the fundraiser end?</label>
            <input type="date" id="endDate" required v-model="editedCampaign.endDate" class="form-input" />
            <!-- <input type="date" id="endDate" required v-model="editedCampaign.endDate" default="{{  }}"/>  -->
        </div>
        <!-- Have to look into v-model for radio buttons -->
        <label for="isPublic">Should your campaign be public or private?</label>
        <div class="button-group" >
            <label> 
                <input type="radio" id="isPublic" :value="true" v-model="editedCampaign.isPublic"/> Public
            </label>
            <label>
                <input type="radio" id="isPublic" :value="false" checked v-model="editedCampaign.isPublic"/> Private
            </label>
        </div>
        <input type="submit" @click.prevent="submitForm" value="Create Campaign"/>
        <input class="form-group" type="cancel" @click.prevent="cancelForm" value="Cancel"/>
    </form>
</div>
</template>


<script>
import campaignService from '../services/CampaignService.js';
import { mapActions } from 'vuex';

export default {
  props: ['campaign'], //bug with props when the content passed is a webcall, shows up in html, is undefined in javascript. dunno what to do about that
  data() {
    return {
        editedCampaign: {
            campaignId: this.campaign ? this.campaign.campaignId : 0,
            title:  this.campaign ? this.campaign.title : '',
            endDate: this.campaign ? this.campaign.endDate : '',
            goal: this.campaign ? this.campaign.goal : '',
            managerId: this.campaign ? this.campaign.managerId : '',
            imgURL: this.campaign ? this.campaign.imgURL : '',
            funding: this.campaign ? this.campaign.funding : '',
            description: this.campaign ? this.campaign.description : '',
            isPublic: this.campaign ? this.campaign.isPublic : ''
        }
    };
  },
  mounted() {
    
    this.updateFormData();
  },
  methods: {
    // ...mapActions(['updateCampaign']), //I'm personally not sure how this works, add back in later?
    // addCampaign() {
    //   const campaign = {
    //     title: this.title,
    //     goal: this.goal,
    //     about: this.about,
    //     pic: this.pic,
    //     visibility: this.visibility
    //   };
    //   this.updateCampaign(campaign); //Does this connect to something outside this file? I think it still needs an id to update a campaign
    //   this.$router.push({ name: 'dashboard' });
    // },
    // onFileChange(event) {
    //   const file = event.target.files[0];
    //   if (file) {
    //     this.pic = URL.createObjectURL(file);
    //   }
    // }
    updateFormData(campaignInfo) {
      console.log(campaignInfo);
      this.editedCampaign = {
            campaignId: campaignInfo ? campaignInfo.campaignId : 0,
            title:  campaignInfo ? campaignInfo.title : '',
            endDate: campaignInfo ? campaignInfo.endDate : '',
            goal: campaignInfo ? campaignInfo.goal : '',
            managerId: campaignInfo ? campaignInfo.managerId : '',
            imgURL: campaignInfo ? campaignInfo.imgURL : '',
            funding: campaignInfo ? campaignInfo.funding : '',
            description: campaignInfo ? campaignInfo.description : '',
            isPublic: campaignInfo ? campaignInfo.isPublic : ''
        }
    },
    submitForm() {
      // Do client-side form validation 
      if (!this.validateForm()) {
        //Form isn't valid, user must update and submit again.
        return;
      }
      // Check for add or edit
      if (this.editedCampaign.campaignId === 0) {
        
        // TODO - Do an add, then navigate Dashboard on success.
        // For errors, call handleErrorResponse
        campaignService.createCampaign(this.editedCampaign).then(response => {
          if(response.status === 201){
            console.log("worked");
            this.$router.push({ name: 'dashboard'}); //need to change route to registered, anon is ok for now
          }
        }).catch(error => {
          this.handleErrorResponse(error, 'adding');
        });

      } else {
        
        // Do an edit, then navigate back to Campaign Details on success
        // For errors, call handleErrorResponse
        campaignService.updateCampaign(this.editedCampaign, this.editedCampaign.campaignId).then(response => {
          if(response.status === 200){
            this.$router.push({ name: 'campaignDetails', params: {id: this.campaign.campaignId} }); //probably same issues w timing, used campaign instead of editedcampaign for router push
          }
        }).catch(error => {
          this.handleErrorResponse(error, 'updating');  
        });
      }
    },
    cancelForm() {
      this.$router.back();
    },
    handleErrorResponse(error, verb) {
      if (error.response) {
        if (error.response.status == 404) {
          this.$router.push({name: 'NotFoundView'});
        } else {
          this.$store.commit('SET_NOTIFICATION',
          `Error ${verb} message. Response received was "${error.response.statusText}".`);
        }
      } else if (error.request) {
        this.$store.commit('SET_NOTIFICATION', `Error ${verb} message. Server could not be reached.`);
      } else {
        this.$store.commit('SET_NOTIFICATION', `Error ${verb} message. Request could not be created.`);
      }
    },
    validateForm() {
      let title = '';

      this.editedCampaign.title = this.editedCampaign.title.trim();
      if (this.editedCampaign.title.length === 0) {
        title += 'The new campaign must have a title. ';
      }

      // this.editCampaign.messageText = this.editCampaign.messageText.trim();
      // if (this.editCampaign.messageText.length === 0) {
      //   msg += 'The message must contain message text.';
      // }

      if (title.length > 0) {
        this.$store.commit('SET_NOTIFICATION', title);
        return false;
      }
      return true;
    }
  }
};

/** 
export default{ 
    methods: {
        addCampaign(){
            //right now it only redirects to the dashboard, gonna add in store stuff later
            this.$router.push({name:'dashboard'});
        }
    },
   
}
*/
</script>


<style>

h1{
    text-align: left;
    max-width: 100%;
}

.grey{
    color: grey;
}

.container {
    display: flex;
    flex-direction: column;
    justify-content: center;
    height: 100vh;
    padding: 10px;
    padding-top: 4.4rem;
    margin-right: 20px;
    font-family: sans-serif,'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;
  
}
.button-group {
    display: flex;
    justify-content: space-evenly;
    margin-bottom: 20px;
}
.button-group label {
    margin-top: 10px;
text-align: center;

}

.button-group input[type="radio"] {

   justify-content: stretch;

}

form input[type="text"],
form input[type="number"],
form textarea {
    width: 100%;
    padding: 10px;
    margin-bottom: 15px;
    border: 1px solid #ccc;
    border-radius: 4px;
}
form input[type ="checkbox"]{
    color: green;
}
form input[type="file"]{
    margin: 20px;
    text-align: left;
}
form input[type="submit"]{
    border-color: #23CF68;
    background-color: #23CF68;
    color: white;
    padding: 5px;
    font-size: large;
    border-radius: 10px;
}

.form-group {
  margin: 20px 0;
  display: flex;
  flex-direction: column;
  border-radius: 4px;
}

.form-label {
  font-weight: bold;
  margin-bottom: 5px;
  color: #333;
  font-size: 1.1em;
}

.form-input {
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 5px;
  font-size: 1em;
  width: 100%;
  box-sizing: border-box;
  transition: border-color 0.3s ease-in-out;
}

.form-input:focus {
  border-color: #4CAF50;
  outline: none;
  box-shadow: 0 0 5px rgba(76, 175, 80, 0.5);
}


/* FOR PHONE ONLY VIEW:  */
@media (max-width: 767px) {
form input[type="submit"]{
    width: 100%;
    height: 50px;
}

}
h1{
    font-size: calc(7vw);
    text-align: left;
}
</style>
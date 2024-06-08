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
        <h1>Create a New Campaign</h1>
    <form @submit.prevent="addCampaign">
        <div>
            <label for="title" class="grey">What will you call your campaign? </label>
            <input type="text" id="title" required v-model="editedCampaign.title"/>
        </div>
        <div>
            <label for="organizer" class="grey">Campaign Organizer</label>
            <input type="text" id="managerId" required v-model="editedCampaign.managerId"/>
        </div>
        <div>
            <label for="goal" class="grey">What is your starting goal? </label>
            <input type="number" id="goal" required v-model="editedCampaign.goal"/>
        </div>
        <div>
            <label for="about" class="grey">Describe your campaign: </label>
            <textarea id="about" name="description" rows="6" cols="50" required v-model="editedCampaign.description"></textarea>
        </div>
        <div>
            <label for="pic">Upload an image: </label>
            <input type="file" id="imageUrl"  accept="image/*" />
        </div>
        <div>
            <label for="timeline">When will the fundraiser end?</label>
            <input type="date" id="endDate" required v-model="editedCampaign.endDate"/>
        </div>
        <!-- Have to look into v-model for radio buttons -->
        <label for="visibility">Should your campaign be public or private?</label>
        <div class="button-group" >
            <label> 
                <input type="radio" name="visibility" value="public" > Public
            </label>
            <label>
                <input type="radio" name="visibility" value="private" checked> Private
            </label>
        </div>
        <input type="submit" @click.prevent="addCampaign" value="Create Campaign"/>
    </form>
</div>
</template>


<script>
import campaignService from '../services/CampaignService.js';
import { mapActions } from 'vuex';

export default {
    props: ['campaign'],
  data() {
    return {
        editedCampaign: {
            title: this.campaign.title,
            endDate: this.campaign.endDate,
            goal: this.campaign.goal,
            managerId: this.campaign.managerId,
            imgURL: this.campaign.imgURL,
            funding: this.campaign.funding,
            description: this.campaign.description,
            isPublic: this.campaign.isPublic
        }
      
    };
  },
  methods: {
    // ...mapActions(['updateCampaign']), //I'm not sure what this is...
    // addCampaign() {
    //   const campaign = {
    //     title: this.title,
    //     goal: this.goal,
    //     about: this.about,
    //     pic: this.pic,
    //     visibility: this.visibility
    //   };
    //   this.updateCampaign(campaign); //Does this connect to something outside this file? Still need id to update a campaign
    //   this.$router.push({ name: 'dashboard' });
    // },
    // onFileChange(event) {
    //   const file = event.target.files[0];
    //   if (file) {
    //     this.pic = URL.createObjectURL(file);
    //   }
    // }
    submitForm() {
      // Do client-side form validation 
      if (!this.validateForm()) {
        //Form isn't valid, user must update and submit again.
        return;
      }
      // Check for add or edit
      if (this.editCampaign.id === 0) {
        
        // TODO - Do an add, then navigate Dashboard on success.
        // For errors, call handleErrorResponse
        campaignService.add(this.editCampaign).then(response => {
          if(response.status === 201){
            this.$router.push({ name: 'dashboard'}); //need to change route to registered, anon is ok for now
          }
        }).catch(error => {
          this.handleErrorResponse(error, 'adding');
        });

      } else {
        
        // TODO - Do an edit, then navigate back to Campaign Details on success
        // For errors, call handleErrorResponse
        campaignService.put(this.editCampaign).then(response => {
          if(response.status === 200){
            this.$router.push({ name: 'campaignDetailsView' ,params: {id: this.editCampaign.campaignId}});
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
      let msg = '';

      this.editMessage.title = this.editMessage.title.trim();
      if (this.editMessage.title.length === 0) {
        msg += 'The new message must have a title. ';
      }

      this.editMessage.messageText = this.editMessage.messageText.trim();
      if (this.editMessage.messageText.length === 0) {
        msg += 'The message must contain message text.';
      }

      if (msg.length > 0) {
        this.$store.commit('SET_NOTIFICATION', msg);
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
    margin-right: 20px;
    font-family: Arial, Helvetica, sans-serif;
  
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
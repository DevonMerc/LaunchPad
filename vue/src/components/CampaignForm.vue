


<template>
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
            <input type="text" id="title" required />
        </div>
        <div>
            <label for="organizer" class="grey">Campaign Organizer</label>
            <input type="text" id="organizerName" required />
        </div>
        <div>
            <label for="goal" class="grey">What is your starting goal? </label>
            <input type="number" id="goal" required/>
        </div>
        <div>
            <label for="about" class="grey">Describe your campaign: </label>
            <textarea id="about" name="about" rows="6" cols="50" required></textarea>
        </div>
        <div>
            <label for="pic">Upload an image: </label>
            <input type="file" id="pic"  accept="image/*"/>
        </div>
        <div>
            <label for="timeline">When will the fundraiser end?</label>
            <input type="file" id="endDate" required/>
        </div>
        <label for="visibility">Should your campaign be public or private?</label>
        <div class="button-group">
            <label> 
                <input type="radio" name="visibility" value="public" checked> Public
            </label>
            <label>
                <input type="radio" name="visibility" value="private"> Private
            </label>
        </div>
        <input type="submit" @click.prevent="addCampaign" value="Create Campaign"/>
    </form>
</div>
</template>


<script>
import { mapActions } from 'vuex';

export default {
  data() {
    return {
      title: '',
      goal: '',
      about: '',
      pic: '',
      visibility: 'public'
    };
  },
  methods: {
    ...mapActions(['updateCampaign']),
    addCampaign() {
      const campaign = {
        title: this.title,
        goal: this.goal,
        about: this.about,
        pic: this.pic,
        visibility: this.visibility
      };
      this.updateCampaign(campaign);
      this.$router.push({ name: 'dashboard' });
    },
    onFileChange(event) {
      const file = event.target.files[0];
      if (file) {
        this.pic = URL.createObjectURL(file);
      }
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
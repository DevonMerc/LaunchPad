<template>
    <div>
      <h1>Donation Form</h1>
    </div>
    <div class="form-container">
      <form @submit.prevent="submitForm">
        <div class="form-group">
          <label for="donationAmount">What amount are you donating ($0.00)?</label>
          <input type="number" id="donationAmount" name="donationAmount" placeholder="What amount are you donating ($0.00)?" required v-model="donation.amount">
        </div>
        <button type="submit" class="submit-btn">Donate</button>
      </form>
    </div>
</template>
  
<script>
  // import { mapGetters, mapMutations } from 'vuex';
  import campaignService from '../services/CampaignService';
  
  export default {
    props: [],
    data() {
      return {
        // donationAmount: 0,
        campaign: {},
        donation: {
          donationId: 0,
          donorId: this.$store.state.user.id,
          campaignId: this.$route.params.campaignId,
          amount: 0, //I have no clue why amount doesn't return null in backend but donationAmount does.. but whatever it works
          // dateTime: ""
          dateTime: Date.now()
        }
      };
    },
  //   computed: {
  //     ...mapGetters(['campaign'])
  //   },
    methods: {
  //     ...mapMutations(['setCampaign']),
      submitForm() {
        //need to create donation and then get campaign by id, then update campaign to adjust funding
        // this.donation.dateTime = Date.now();
        campaignService.createDonation(this.donation).then(response => {
          if(response.status === 201){
            console.log("worked");
          }
        }).catch(error => {
          console.log(`something went wrong with creating a new donation. Response status: ${error.response.status}`);
        });

        // console.log(this.campaign.funding);
        // console.log(this.campaign);
        this.campaign.funding += this.donation.amount;
        // console.log(this.campaign.funding);
        campaignService.updateCampaign(this.campaign, this.campaign.campaignId).then(response => {
          if(response.status === 200){
            // console.log(this.campaign);
            this.$router.push({name: 'campaignDetails', params: {id: this.$route.params.campaignId}});
          }
        }).catch(error => {
          console.log(`something went wrong with updating funds of the campaign. Response status: ${error.response.status}`);
        });
  //       const campaignData = {
  //         title: this.title,
  //         request: this.request,
  //         manager: this.manager,
  //         description: this.description
  //       };
  //       this.setCampaign(campaignData);
  //       this.$router.push('/campaign-voting');
      },
      cancelForm() {
        this.$router.back();
      },
      setCampaign(response){ //OK oh my god, from now on set local variables with methods for web calls
        this.campaign = response.data;
      }
    },
    created(){//probably should pass this in from a view but idk
      campaignService.getCampaignById(this.donation.campaignId).then(response => {
        if(response.status === 200){
          this.setCampaign(response);
        }
      });
    }
  }
</script>
  
<style>
</style>
  
<template>
  <!-- NEED TO MAKE SURE I CAN SEE CURRENT USERS CAMPAIGNS ONCE CREATE CAMPAIGNS WORKS-->
    <div class="dashboard">
    <!-- <p>You are authenticated if you see this. can delete this later</p> -->
    <!-- <div>{{ $store.state.user }}</div> -->
    <site-header />
    <body>
      <button @click="$router.push( { name: 'createCampaign'} )">Start a new campaign</button>
      <h3>Your Campaigns</h3> 
      <div>
        <!-- <campaign-list :campaigns="this.$store.state.campaigns"/> -->
        <campaign-list :campaigns="userCampaigns"/>
      </div>
    </body>
  </div>
</template>

<script>
import CampaignList from '../components/CampaignList.vue'; 
import SiteHeader from '../components/SiteHeader.vue';
import campaignService from '../services/CampaignService.js';

export default{
    components: {
        SiteHeader,
        CampaignList
    },
    data(){
      return {
        campaigns: [] //not really sure just using this isnt working
        //   isLoading: true
      }
    },
  methods: {
    callUserCampaigns() {
      //right now its taking in a userId, that's backup since principal isnt working, change back later if that's figured out
      campaignService.getUserCampaigns(this.$store.state.user.id).then(response => {
        // console.log(response.data);
        this.campaigns = response.data;
        // this.isLoading = false;
      }).catch( error => {
        console.log(error);
      })
      if(this.campaigns.length === 0){
        this.campaigns = [{
          campaignId: 0,
          title: "No Campaigns created",
          endDate: "",
          goal: 0.00,
          managerId: 0,
          imgURL: "",
          funding: 0.00,
          description: "",
          isPublic: false
        }];
      }
    },
    created() { //what does this do again
      this.callUserCampaigns();
    }
  },
    computed: {
    // userCampaigns(){
    //   const filteredCampaigns = this.$store.state.campaigns.filter( campaign => {
    //     return campaign.campaignManagerId === this.$store.state.user.id;
    //   });
    //   return filteredCampaigns;
    // },
    userCampaigns(){
      this.callUserCampaigns();
      const test = this.campaigns; //for debugging
      // if(this.campaigns.length === 0){
      //   return [{
      //     campaignId: -1,
      //     title: "No Campaigns created",
      //     endDate: "",
      //     goal: 0.00,
      //     managerId: 8,
      //     imgURL: "",
      //     funding: 0.00,
      //     description: "",
      //     isPublic: false
      //   }]
      // }
      return this.campaigns;
    }
  }
}
</script>
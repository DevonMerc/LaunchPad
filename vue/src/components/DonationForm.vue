<template>
    <div>
      <h1>Donation Form</h1>
    </div>
    <div class="form-container">
      <form @submit.prevent="submitForm">
        <div class="form-group">
          <input v-model="title" type="text" id="donationAmount" name="donationAmount" placeholder="What amount are you donating ($0.00)?" required>
        </div>
        <button type="submit" class="submit-btn">Donate</button>
      </form>
    </div>
</template>
  
<script>
  import { mapGetters, mapMutations } from 'vuex';
  
  export default {
    data() {
      return {
        donationAmount: ''
      };
    },
    computed: {
      ...mapGetters(['campaign'])
    },
    methods: {
      ...mapMutations(['setCampaign']),
      submitForm() {
        const campaignData = {
          title: this.title,
          request: this.request,
          manager: this.manager,
          description: this.description
        };
        this.setCampaign(campaignData);
        this.$router.push('/campaign-voting');
      }
    }
  };
</script>
  
<style>
</style>
  
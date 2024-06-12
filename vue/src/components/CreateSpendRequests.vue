<template>
    <div class="create-spend-request">
      <h1>Create Spend Request</h1>
      <form @submit.prevent="createSpendRequest">
        <div>
          <label for="amount">Amount:</label>
          <input type="number" v-model="amount" required />
        </div>
        <div>
          <label for="reason">Reason:</label>
          <input type="text" v-model="reason" required />
        </div>
        <button type="submit">Create Request</button>
      </form>
    </div>
</template>
  
<script>
  export default {
    data() {
      return {
        amount: '',
        reason: '',
      };
    },
    methods: {
      createSpendRequest() {
        // Logic to save the request to a backend or state management system
        // For simplicity, using local storage in this example
        localStorage.setItem('spendRequest', JSON.stringify({ amount: this.amount, reason: this.reason }));
        alert('Spend request created successfully');
        this.amount = '';
        this.reason = '';
      },
    },
  };
</script>
  
<style scoped>
  .create-spend-request {
    padding: 2rem;
  }
</style>
  
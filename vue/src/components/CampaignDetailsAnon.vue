<template>

    <!-- <button>Menu</button> -->
    <div class="container">
      <img src="../assets/Launchpad-logo-full.png" alt="Place Holder">
      <h1>{{ campaign.title }}</h1>
      <p>Goal: {{ campaign.goal }}</p>
      <p>Description: {{ campaign.description }}</p>
      <!-- <p>Visibility: {{ campaign.isPublic }}</p> -->
      <!-- Commenting vvv out for now bc we don't have images figured out -->
      <!-- <div v-if="campaign.imgURL">
        <img src="../assets/PLACEHOLDER_LOGO.png" alt="Place Holder">
      </div> -->
    </div>
  </template>
  
  <script>
  // import { mapGetters } from 'vuex';
  
  export default {
    props: ['campaign'],
    computed: {
      // ...mapGetters(['campaign'])
    }
  };
  </script>
  
<style>
.container{
  display: flex;
  position: relative; 
  top: -70px;
  padding: 1rem;
  align-items: center;
}

.container img{
  width: 150px;
  height: auto;
  display: flex;
}

h1{
  text-align: center;
  position: relative; 
  top: 25px;
  font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
  font-size: 1.5rem;
}

p{
  text-align: center;
  position: relative; 
  top: 25px;
  font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
  font-size: 1rem;
}
</style>
  
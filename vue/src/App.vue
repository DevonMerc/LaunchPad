<template>
  <div id="capstone-app">
    <div id="nav">
      <!--<router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp; -->
      <!-- <router-link v-bind:to="{ name: 'logout' }" v-if="this.$store.state.token != ''">Logout</router-link> -->
    </div>
    <router-view />
  </div>
</template>

<style>
body{
  background-color: rgb(248, 243, 237);
}
*{
  color: rgb(25, 117, 7);
  font-family: sans-serif,'Gill Sans', 'Gill Sans MT', 'Calibri', 'Trebuchet MS';
  margin:0;
}

button{
  background-color: #e7a325;
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

.campaign-form-h1{
  margin: auto;
}

</style>

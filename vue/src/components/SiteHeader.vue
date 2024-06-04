<template>
    <header>
      <!-- some img/icon
      menu button -> goes to menuview -->
      <router-link v-bind:to="{ name: 'home' }"><h1>LaunchPad</h1></router-link>
      <!-- Idea, we have an array and loop through options based on the authenticated role of user or something. -->
      <button @click="$router.push({name: 'menu'})">Menu</button>
    </header>
</template>

<script>
export default{

}
</script>

<style scoped>
/* started some styling, change however */
  header{
    display: flex;
    justify-content: left;
    align-items: top;
  }
</style>
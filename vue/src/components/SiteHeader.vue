<template>
  <header class="site-header">
    <router-link v-bind:to="{ name: 'home' }" class="logo">
      <img src="../assets/Launchpad-logo-full.png" alt="LaunchPad" />
    </router-link>
    <button @click="$router.push({ name: 'menu' })" class="menu-button">Menu</button>
  </header>
</template>

<script>
export default {
  name: "SiteHeader"
};
</script>

<style scoped>
.site-header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 1rem;
  background-color: white;
  border-bottom: 2px solid aliceblue;
}

.logo img {
  width: 10rem;
}

.menu-button {
  background-color: rgb(228, 225, 225);
  color: black;
  font-weight: bolder;
  font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
  border: none;
  padding: 0.5rem 1rem;
  font-size: 1rem;
  border-radius: 4px;
}

@media (min-width: 600px) {
  .site-header {
    padding: 1rem 2rem;
  }

  .logo img {
    width: 300px; 
  }

  .menu-button {
    padding: 0.75rem 1.5rem;
    font-size: 1.2rem;
  }
}
</style>

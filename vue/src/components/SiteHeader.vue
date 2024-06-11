<template>
  <header class="site-header">
    <router-link v-bind:to="{ name: 'home' }" class="logo">
      <img src="../assets/Launchpad-logo-full.png" alt="LaunchPad" />
    </router-link>
    <nav class="nav-buttons">
      <button @click="$router.push({ name: 'menu' })" class="menu-button">Menu</button>
      <button v-if="this.$store.state.token != ''" @click="logout" class="logout-button">
        Logout
      </button>
      <button class="login-button" @click="this.$router.push({ name: 'createCampaign' })">
        Login
      </button>
    </nav>
  </header>
</template>

<script>
export default {
  name: "SiteHeader",
  methods: {
    logout() {
      this.$router.push({ name: 'logout' });
    }
  }
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
  position: fixed; 
  width: 100%; 
  top: 0; 
  z-index: 1000; 
  box-sizing: border-box; 
}

.logo {
  flex: 1; 
}

.logo img {
  max-width: 100%;
  height: auto;
}

.nav-buttons {
  display: flex;
  flex: 2; 
  justify-content: flex-end; 
}

.menu-button, .logout-button, .login-button {
  background-color: rgb(228, 225, 225);
  color: black;
  font-weight: bolder;
  font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
  border: none;
  padding: 0.5rem 1rem;
  font-size: 1rem;
  border-radius: 4px;
  cursor: pointer;
}

@media (min-width: 600px) {
  .site-header {
    padding: 1rem 2rem;
  }

  .menu-button, .logout-button, .login-button {
    padding: 0.75rem 1.5rem;
    font-size: 1.2rem;
  }
}
</style>

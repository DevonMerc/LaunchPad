<template> 
  
  <div id="login" class="container">
    <header>
      <img src="../assets/PLACEHOLDER_LOGO.png" alt="LaunchPad">
    </header>
  
    <form v-on:submit.prevent="login">
      <h1 >Enter your username and password</h1>
      <div role="alert" v-if="invalidCredentials">
        Invalid username and password!
      </div>
      <div role="alert" v-if="this.$route.query.registration">
        Thank you for registering, please sign in.
      </div>
      <div class="form-input-group">
        <label for="username">Username</label>
        <input type="text" id="username" v-model="user.username" required autofocus />
      </div>
      <div class="form-input-group">
        <label for="password">Password</label>
        <input type="password" id="password" v-model="user.password" required />
      </div>
      <button type="submit">Log in</button>
      <p>
      <router-link v-bind:to="{ name: 'register' }" class="link">Need an account? Sign up here</router-link></p>
    </form>
  </div>

</template>

<script>
import authService from "../services/AuthService";

export default {
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: ""
      },
      invalidCredentials: false
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
        })
        .catch(error => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    }
  }
};
</script>

<style scoped>
.container{
  display: flex;
}
.form-input-group {
  margin-bottom: 1rem;
}
label {
  margin-right: 0.5rem;
}
h1{
  text-align: center;

}
button{
  fill: #23CF68;
  color: white;
    padding: 5px;
    font-size: large;
    border-color: #23CF68;
}
header{
  align-self: center;
}
header img{
    width: 20%;
    display: flex;
    align-content: top;
    justify-content: center;
  }
  /* header{
    display: flex;
    justify-content: left;
    align-items: top;
  } */
.link{
  display: flex;
  text-align: center;
  font-style: italic;
  justify-content: space-evenly;
}
@media (max-width: 767px) {
button{
    width: 100%;
    background-color:#23CF68;
  
}

}
</style>
<template>
  <div id="loginContainer">
    <div id="loginTitle">
      <label>Please login!</label>
    </div>
    <label id="loginStatusLabel" v-if="!loginSuccess"
      >Login: {{ loginstatus }}</label
    >
    <div id="username">
      <label id="usernameLabel">Username:</label>
      <textarea v-model="username"></textarea>
    </div>
    <div id="password">
      <label id="passwordLabel">Password: </label>
      <textarea v-model="password"></textarea>
      <button @click="handleClickSignin">Sign in</button>
    </div>
    <div class="registerContainer" v-if="!loginSuccess">
      <div class="notRegistered">Not yet registered?</div>
      <router-link :to="{ name: 'Register' }">Register</router-link>
    </div>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "LoginComponent",
  methods: {
    async handleClickSignin() {
      //alert("You entered the username: " + this.username);
      const loginRequest = { username: this.username, password: this.password };
      const loginResponse = await axios.post(
        "http://localhost:8085/demo/login",
        loginRequest
      );
      console.log("Login " + loginResponse.data.loginStatus);
      this.loginstatus = loginResponse.data.loginStatus;

      if (this.loginstatus === "Success") {
        this.loginSuccess = true;

        this.$store.dispatch("updateFlashMessage", "Login was Successful!");
        setTimeout(() => {
          this.$store.dispatch("updateFlashMessage", "");
        }, 3000);

        this.$router.push({
          name: "Home",
        });
      } else {
        this.loginSuccess = false;
        console.log("Inside else bracket");
      }
    },
  },
  data() {
    return {
      username: "",
      password: "",
      loginstatus: "",
      loginSuccess: true,
    };
  },
};
</script>

<style scoped>
#loginContainer {
  display: grid;
  justify-content: center;
  margin: 40px;
}

#loginTitle {
  font-size: x-large;
  font-weight: bold;
  margin-bottom: 20px;
}
#loginStatusLabel {
  margin-bottom: 1rem;
}

#username,
#password {
  display: flex;
  flex-direction: row;
  align-items: center;
  column-gap: 20px;
}

#usernameLabel,
#passwordLabel {
  width: 100px;
}

.registerContainer {
  display: flex;
  flex-direction: row;
  margin: 0 auto;
  margin-top: 3rem;
}

.notRegistered {
  margin-right: 0.5rem;
}
</style>

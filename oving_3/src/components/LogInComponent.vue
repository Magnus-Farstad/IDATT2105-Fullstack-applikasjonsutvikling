<template>
  <div id="loginContainer">
    <div id="loginTitle">
      <label>Please login!</label>
    </div>
    <div id="username">
      <label id="usernameLabel">Username:</label>
      <textarea v-model="username"></textarea>
    </div>
    <div id="password">
      <label id="passwordLabel">Password: </label>
      <textarea v-model="password"></textarea>
      <button @click="handleClickSignin">Sign in</button>
    </div>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "LoginComponent",
  methods: {
    async handleClickSignin() {
      alert("You entered the username: " + this.username);
      const loginRequest = { username: this.username, password: this.password };
      const loginResponse = await axios.post(
        "http://localhost:8085/login",
        loginRequest
      );
      alert("Login " + loginResponse.data);
    },
  },
  data() {
    return {
      username: "",
      password: "",
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
</style>

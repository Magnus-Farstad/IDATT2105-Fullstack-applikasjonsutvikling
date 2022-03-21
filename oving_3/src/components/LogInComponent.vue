<template>
  <div id="loginContainer">
    <div id="loginTitle">
      <label data-testid="loginLabel">Please login!</label>
    </div>
    <label id="loginStatusLabel">{{ $store.state.loginStatus }}</label>
    <div id="username">
      <label id="usernameLabel">Username:</label>
      <input id="usernameInput" v-model="username" />
    </div>
    <div id="password">
      <label id="passwordLabel">Password: </label>
      <input id="passwordInput" v-model="password" />
      <button id="signInButton" @click="handleClickSignin">Sign in</button>
    </div>
    <div
      data-testid="registerContainer"
      class="registerContainer"
      v-show="!loginSuccess"
    >
      <div class="notRegistered">Not yet registered?</div>
      <router-link :to="{ name: 'Register' }">Register</router-link>
    </div>
  </div>
  <div id="buttonPressed" v-show="buttonPressed"></div>
</template>

<script>
import { doLogin } from "@/utils/apiutils";
import { getJwtToken } from "@/utils/apiutils";

export default {
  name: "LoginComponent",
  methods: {
    async handleClickSignin() {
      const loginRequest = { username: this.username, password: this.password };
      this.handleClickSignin2();

      const tokenResponse = await getJwtToken("admin", "password");
      this.$store.dispatch("addJwtToken", tokenResponse);

      const loginResponse = await doLogin(
        loginRequest,
        this.$store.state.jwtToken
      );
      console.log("Login " + loginResponse.loginStatus);
      console.log("Login id: " + loginResponse.user_id);
      //this.loginstatus = loginResponse.loginStatus;

      this.$store.dispatch("updateLoginStatus", loginResponse.loginStatus);

      this.loginstatus = this.$store.state.loginStatus;

      if (this.loginstatus === "Success") {
        this.loginSuccess = true;

        this.$store.dispatch("updateCurrentUser", loginResponse);
        this.$store.dispatch("updateFlashMessage", "Login was Successful!");
        setTimeout(() => {
          this.$store.dispatch("updateFlashMessage", "");
        }, 3000);

        this.$router.push({
          name: "Home",
        });
      } else {
        this.loginSuccess = false;
      }
    },
    handleClickSignin2() {
      this.buttonPressed = true;
    },
  },
  data() {
    return {
      username: "",
      password: "",
      loginstatus: "",
      loginSuccess: true,
      buttonPressed: false,
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

input {
  min-height: 2rem;
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

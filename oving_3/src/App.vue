<template>
  <div id="flashMessage" v-if="$store.state.flashMessage">
    {{ $store.state.flashMessage }}
  </div>
  <div id="nav">
    <div v-if="$store.state.userLoggedIn" class="currentUser">
      {{ $store.state.currentUser.name }}
    </div>
    <div>
      <router-link :to="{ name: 'Home' }">Home</router-link>
      <router-link :to="{ name: 'ContactForm' }">Contact</router-link>
      <router-link :to="{ name: 'About' }">About</router-link>
      <router-link :to="{ name: 'LogIn' }" v-if="!$store.state.userLoggedIn"
        >Log in
      </router-link>
      <button class="button-24" v-else @click="logOut">Log out</button>
    </div>
  </div>
  <router-view />
</template>

<script>
export default {
  methods: {
    logOut() {
      this.$store.dispatch("logOutUser");
    },
  },
};
</script>

<style>
@keyframes yellowfade {
  from {
    background: yellow;
  }
  to {
    background: transparent;
  }
}

body {
  align-items: center;
}

.currentUser {
  margin-right: 1rem;
}

#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

#flashMessage {
  animation-name: yellowfade;
  animation-duration: 3s;
}

#nav {
  padding: 30px;
  display: flex;
  flex-direction: row;
  align-items: center;
  justify-content: center;
}

#nav a {
  font-weight: bold;
  color: #2c3e50;
  text-decoration: none;
  padding: 10px;
  border-radius: 5px;
}

#nav a.router-link-exact-active {
  color: white;
  background: crimson;
  font-weight: bolder;
}

.button-24 {
  background: rgba(208, 18, 56, 0.8);
  border: 1px solid rgba(208, 18, 56, 0.8);
  border-radius: 6px;
  box-shadow: rgba(0, 0, 0, 0.1) 1px 2px 4px;
  box-sizing: border-box;
  color: #ffffff;
  cursor: pointer;
  display: inline-block;
  font-size: 16px;
  font-weight: 800;
  line-height: 16px;
  margin-left: 10px;
  outline: 0;
  padding: 5px;
  text-align: center;
  text-rendering: geometricprecision;
  text-transform: none;
  user-select: none;
  -webkit-user-select: none;
  touch-action: manipulation;
  vertical-align: middle;
}

.button-24:hover,
.button-24:active {
  background-color: initial;
  background-position: 0 0;
  color: rgba(208, 18, 56, 0.8);
}

.button-24:active {
  opacity: 0.5;
}

.logOutButton {
  color: white;
  font-weight: bold;
  padding: 5px;
  margin-left: 10px;
  cursor: pointer;
  background: crimson;
  border-radius: 5px;
}
</style>

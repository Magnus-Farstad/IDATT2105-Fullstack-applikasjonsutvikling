<template>
  <div id="flashMessage" v-if="$store.state.flashMessage">
    {{ $store.state.flashMessage }}
  </div>
  <div id="nav">
    <div v-if="$store.state.userLoggedIn" class="currentUser">{{ $store.state.currentUser.name }}</div>
    <div>
      <router-link :to="{ name: 'Home' }">Home</router-link> |
      <router-link :to="{ name: 'ContactForm' }">Contact</router-link> |
      <router-link :to="{ name: 'About' }">About</router-link> |
      <router-link :to="{ name: 'LogIn' }" v-if="!$store.state.userLoggedIn"
        >Log in
      </router-link>
      <button v-else @click="logOut">Log out</button>
    </div>
  </div>
  <router-view />
</template>

<script>
export default {
  methods: {
    logOut() {
      this.$store.dispatch("logOutUser");
    }
  }
}
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
  margin-right: 3rem;
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
}

#nav a.router-link-exact-active {
  color: #42b983;
}
</style>

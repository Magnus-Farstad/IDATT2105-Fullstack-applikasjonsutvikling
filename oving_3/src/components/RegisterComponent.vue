<template>
  <h2 class="registerMessage">Register!</h2>
  <div class="registerContainer">
    <BaseInput id="name" v-model="name" label="Full name" type="text"></BaseInput>
    <BaseInput v-model="address" label="Address" type="text"></BaseInput>
    <BaseInput v-model="username" label="Username" type="text"></BaseInput>
    <BaseInput v-model="password" label="Password" type="text"></BaseInput>
    <BaseInput v-model="email" label="Email" type="text"></BaseInput>
    <BaseInput v-model="phone" label="Phone" type="number"></BaseInput>
    <button
        id="registerbutton"
      :disabled="isDisabled"
      :class="{ disabledButton: isDisabled }"
      class="registerButton"
      @click="handleRegister"
    >
      Register
    </button>
  </div>
</template>

<script>
import BaseInput from "@/components/BaseInput";
export default {
  name: "RegisterComponent",
  components: {
    BaseInput,
  },
  data() {
    return {
      name: "",
      address: "",
      username: "",
      password: "",
      email: "",
      phone: "",
    };
  },
  methods: {
    handleRegister() {
      this.$store.dispatch("updateFlashMessage", "Register was Successful!");
      setTimeout(() => {
        this.$store.dispatch("updateFlashMessage", "");
      }, 3000);

      this.$store.dispatch("updateLoginStatus", "");

      this.$router.push({
        name: "Home",
      });
    },
  },
  computed: {
    isDisabled() {
      return (
        this.name === "" ||
        this.address === "" ||
        this.username === "" ||
        this.password === "" ||
        this.email === "" ||
        this.phone === ""
      );
    },
  },
};
</script>

<style scoped>
.registerButton {
}

.disabledButton {
  background-color: #d8d8d8;
  cursor: not-allowed;
}

.registerContainer {
  width: 425px;
  margin: 0 auto;
  margin-top: 2rem;
  padding: 20px;
  border: 2px solid #d8d8d8;
  background-color: white;
  -webkit-box-shadow: 0px 2px 15px -12px rgba(0, 0, 0, 0.57);
  -moz-box-shadow: 0px 2px 15px -12px rgba(0, 0, 0, 0.57);
  box-shadow: 2px 15px -12px rgba(0, 0, 0, 0.57);
}
</style>

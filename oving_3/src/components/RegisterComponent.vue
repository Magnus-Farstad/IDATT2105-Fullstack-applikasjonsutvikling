<template>
  <h2 class="registerMessage">Register!</h2>
  <div class="registerContainer">
    <BaseInput
      id="name"
      v-model="name"
      label="Full name"
      type="text"
    ></BaseInput>
    <BaseInput v-model="address" label="Address" type="text"></BaseInput>
    <BaseInput v-model="username" label="Username" type="text"></BaseInput>
    <BaseInput v-model="password" label="Password" type="text"></BaseInput>
    <BaseInput v-model="email" label="Email" type="text"></BaseInput>
    <BaseInput v-model="phone" label="Phone" type="Number"></BaseInput>
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
import { doRegistration } from "@/utils/apiutils";

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
      validRegistration: false,
    };
  },
  methods: {
    async handleRegister() {
      this.isValid();
      console.log(
        "validRegistration is: " +
          this.validRegistration +
          " of type: " +
          typeof this.validRegistration
      );
      if (this.validRegistration === true) {
        let user = {
          name: this.name,
          address: this.address,
          username: this.username,
          password: this.password,
          email: this.email,
          phone: this.phone,
        };

        let registerResponse = await doRegistration(user, this.$store.state.jwtToken);
        console.log(registerResponse.registerStatus);

        if (registerResponse.registerStatus === "Register was Successful!") {
          this.$store.dispatch(
            "updateFlashMessage",
            "Register was Successful!"
          );
          setTimeout(() => {
            this.$store.dispatch("updateFlashMessage", "");
          }, 3000);

          this.$store.dispatch("updateLoginStatus", "");

          this.$router.push({
            name: "Home",
          });
        }
      } else {
        alert(this.validRegistration);
      }
    },
    isValid() {
      let matches = this.name.match(/\d+/g);
      if (matches === null) {
        this.validEmail();
      } else {
        this.validRegistration = "Name cannot contain numbers";
      }
    },
    validEmail() {
      const regex =
        /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
      if (!regex.test(String(this.email).toLowerCase())) {
        this.validRegistration = "Please enter a valid email address";
        console.log(this.validRegistration);
      } else {
        this.validRegistration = true;
      }
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

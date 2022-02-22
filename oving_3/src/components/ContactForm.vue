<template>
  <div class="contact-form">
    <h1>Leave a review!</h1>
    <form class="review-form" @submit.prevent="onSubmit">
      <h3>Name and E-mail</h3>

      <BaseInput v-model="name" label="Name" type="text" />

      <BaseInput v-model="email" label="E-mail" type="text" />

      <h3>Review</h3>

      <label for="review">Review:</label>
      <textarea id="review" v-model="review"></textarea>

      <input
        :disabled="isDisabled"
        class="button"
        :class="{ disabledButton: isDisabled }"
        type="submit"
        value="Submit"
      />
    </form>
    <div class="footer">
      <div class="helper">{{ $store.state.reviews }}</div>
      <div class="status">{{ $store.state.status }}</div>
    </div>
  </div>
</template>

<script>
import { v4 as uuidv4 } from "uuid";
import BaseInput from "@/components/BaseInput";

export default {
  name: "ContactForm",
  components: { BaseInput },
  data() {
    return {
      name: "",
      email: "",
      review: "",
      id: "",
    };
  },
  methods: {
    onSubmit() {
      if (!this.isValid()) {
        alert("Numbers are not allowed in field Name");
        return;
      }
      this.showStatusMessage();

      this.id = uuidv4();
      let productReview = {
        name: this.name,
        email: this.email,
        review: this.review,
        id: this.id,
      };
      this.$store.dispatch("createReview", productReview);

      this.name = "";
      this.email = "";
      this.review = "";
      this.id = "";
    },
    isValid() {
      let matches = this.name.match(/\d+/g);
      return matches == null;
    },
    showStatusMessage() {
      this.$store.dispatch("updateStatus", "sender...");
      setTimeout(() => {
        this.$store.dispatch("updateStatus", "Sendt!");
      }, 2000);
    },
  },
  computed: {
    isDisabled() {
      return this.name === "" || this.email === "" || this.review === "";
    },
  },
};
</script>

<style scoped>
.contact-form {
  margin: 0 auto;
  align-items: center;
  justify-content: center;
  position: relative;
}

.button {
  margin-top: 10px;
}

.disabledButton {
  background-color: #d8d8d8;
  cursor: not-allowed;
}

input {
  width: 100%;
  height: 40px;
  margin-bottom: 20px;
}

label {
  font-size: 20px;
  margin-bottom: 5px;
}

#review {
  min-height: 100px;
  overflow: auto;
}

.review-form {
  display: flex;
  flex-direction: column;
  width: 425px;
  padding: 20px;
  margin: 40px;
  border: 2px solid #d8d8d8;
  background-color: white;
  -webkit-box-shadow: 0px 2px 15px -12px rgba(0, 0, 0, 0.57);
  -moz-box-shadow: 0px 2px 15px -12px rgba(0, 0, 0, 0.57);
  box-shadow: 2px 15px -12px rgba(0, 0, 0, 0.57);
}
</style>

<template>
  <div class="contact-form">
    <form class="review-form" @submit.prevent="onSubmit">
      <h3>Leave a review</h3>
      <label for="name">Name:</label>
      <input id="name" v-model="name" />

      <label>E-mail</label>
      <input id="email" v-model="email" />

      <label for="review">Review:</label>
      <textarea id="review" v-model="review"></textarea>

      <input class="button" type="submit" value="Submit" />
    </form>
  </div>
</template>

<script>
export default {
  name: "ContactForm",
  data() {
    return {
      name: "",
      email: "",
      review: "",
    };
  },
  methods: {
    onSubmit() {
      let productReview = {
        name: this.name,
        email: this.email,
        review: this.review,
      };
      this.$emit("review-submitted", productReview);

      this.name = "";
      this.email = "";
      this.review = "";
    },
  },
};
</script>

<style scoped>
.contact-form {
  margin: 0 auto;
  align-items: center;
}

.button {
  margin-top: 10px;
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

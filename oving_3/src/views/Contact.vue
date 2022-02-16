<template>
  <div class="contact">
    <ContactForm></ContactForm>
  </div>
</template>

<script>
import ContactForm from "@/components/ContactForm";

export default {
  name: "Contact",
  components: {
    ContactForm,
  },
};
</script>

<style scoped>
.contact {
  display: flex;
  margin: 0 auto;
  align-items: center;
}
</style>

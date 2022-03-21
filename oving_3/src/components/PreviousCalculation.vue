<template>
  <div class="container">
    <div>{{ calculation.calculation }}</div>
  </div>
</template>

<script>
export default {
  name: "PreviousCalculation",
  props: {
    calculation: {
      type: String,
    },
  },
};
</script>

<style scoped>
.container {
  background: #f4f4f4;
  border: solid black 1px;
  border-radius: 10px;
  color: black;
  font-weight: bold;
  padding: 10px;
  max-width: 200px;
  margin: 0 auto;
}
</style>

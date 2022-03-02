<template>
  <div id="scrollBox" class="log">
    <ul id="arrayUnorderedList">
      <li v-for="(equation, index) in equations" :key="index">
        {{ equation }}
      </li>
    </ul>
  </div>
</template>

<script>
export default {
  name: "Log",
  props: {
    equations: {
      type: Array,
      required: true,
    },
  },
};
</script>

<style scoped>
#scrollBox {
  overflow: scroll;
  border: solid black;
  margin-top: 10px;
  height: 400px;
  background-color: rgba(255, 165, 0, 0.14);
  border-radius: 5px;
}

.log {
  grid-area: log;
}
</style>

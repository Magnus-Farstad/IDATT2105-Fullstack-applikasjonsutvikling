<template>
  <div id="scrollBox" class="log">
    <ul id="arrayUnorderedList">
      <li class="item" v-for="(equation, index) in equations" :key="index">
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
  overflow: auto;
  border: solid black;
  color: white;
  margin-top: 10px;
  height: 200px;
  background-color: #524A4E;
  border-radius: 5px;
}

.item {
  font-size: 25px;
}

.log {
  grid-area: log;
}
</style>

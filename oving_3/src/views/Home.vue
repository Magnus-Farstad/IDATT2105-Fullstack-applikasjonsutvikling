<template>
  <div class="home">
    <div class="headerContainer">
      <h1 class="header">Calculator</h1>
    </div>
    <div id="calculatorContainer" v-show="isUserLoggedIn">
      <calculator @add-equations="addEquation"></calculator>
      <log :equations="equations"></log>
    </div>
  </div>
</template>

<script>
// @ is an alias to /src
//import HelloWorld from "@/components/HelloWorld.vue";
import Calculator from "@/components/Calculator.vue";
import Log from "@/components/Log.vue";

export default {
  name: "Home",
  components: {
    Calculator,
    Log,
  },
  data() {
    return {
      equations: [],
    };
  },
  methods: {
    addEquation(equation) {
      this.equations.push(equation);
      //console.log(equation);
      // for (let i = 0; i < this.equations.length; i++) {
      //   console.log(this.equations[i]);
      // }
    },
  },
  computed: {
    isUserLoggedIn() {
      return this.$store.state.currentUser.userId !== null;
    },
  },
};
</script>
<style scoped>
body {
  align-items: center;
}

#calculatorContainer {
  display: grid;
  grid-template-areas:
    "display display display display"
    "c ans del plus"
    "one two three subtract"
    "four five six multiply"
    "seven eight nine divide"
    "empty zero point equals"
    "log log log log";
  background-color: #eee;
  padding: 7px;
  height: 70%;
  margin: 0 auto;
  text-align: center;
  width: 30%;
  font-size: 35px;
  grid-auto-rows: minmax(50px, auto);
  box-shadow: 0 0 16px #363535;
  border-radius: 10px;
  align-items: center;
}

.headerContainer {
  margin: 20px auto;
  text-align: center;
}

.header {
  font-size: 50px;
  font-weight: 900;
  margin: 15px;
}

.text {
}
</style>

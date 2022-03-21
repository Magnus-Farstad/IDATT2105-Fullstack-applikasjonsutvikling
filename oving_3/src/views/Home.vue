<template>
  <div class="home">
    <div class="headerContainer">
      <h1 class="header">Calculator</h1>
    </div>
    <div id="container" v-if="isUserLoggedIn">
      <div id="calculatorContainer">
        <calculator @add-equations="addEquation"></calculator>
        <log :equations="equations"></log>
      </div>
      <div>
        <button class="viewCalculationsButton" @click="getAllCalculations">
          View previous calculations
        </button>
        <div
          class="previousCalculations"
          v-for="(calculation, index) in calculations"
          :key="index"
        >
          {{ calculation.calculation }}
        </div>
      </div>
    </div>
    <div v-else>
      <h2>Welcome to my calculator!</h2>
      <div>Log in to start using the calculator</div>
    </div>
  </div>
</template>

<script>
// @ is an alias to /src
//import HelloWorld from "@/components/HelloWorld.vue";
import Calculator from "@/components/Calculator.vue";
import Log from "@/components/Log.vue";
import { getAllCalculations } from "@/utils/apiutils";

export default {
  name: "Home",
  components: {
    Calculator,
    Log,
  },
  data() {
    return {
      equations: [],
      calculations: [],
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
    async getAllCalculations() {
      console.log(typeof this.$store.state.currentUser.userId);
      let currentUserId = this.$store.state.currentUser.userId;
      let response = await getAllCalculations(
        currentUserId,
        this.$store.state.jwtToken
      );
      this.calculations = response;
    },
  },
  computed: {
    isUserLoggedIn() {
      return this.$store.state.userLoggedIn;
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
  width: 30%;
  font-size: 35px;
  box-shadow: 0 0 16px #363535;
  border-radius: 10px;
}

.headerContainer {
  margin: 20px auto;
  text-align: center;
}

.header {
  font-size: 50px;
  font-weight: 900;
  margin: 5px;
}
.viewCalculationsButton {
  margin: 2rem;
}

.text {
}
</style>

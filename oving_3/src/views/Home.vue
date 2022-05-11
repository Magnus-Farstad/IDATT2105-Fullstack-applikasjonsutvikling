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

        <div v-if="calculationsExist" class="previousCalculationsContainer">
          <div class="exitContainer">
            <span @click="exitDropDown" id="exitDropDown">x</span>
          </div>
          <div
            class="row"
            v-for="(calculation, index) in calculations"
            :key="index"
          >
            <span id="deleteContainer">
              <span @click="deleteCalculation(calculation.id)" id="delete"
                >x</span
              >
            </span>
            <span>
              <PreviousCalculation
                class="previousCalculations"
                :calculation="calculation"
              ></PreviousCalculation>
            </span>
          </div>
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
import PreviousCalculation from "@/components/PreviousCalculation";
import { deleteCalculation, getAllCalculations } from "@/utils/apiutils";

export default {
  name: "Home",
  components: {
    Calculator,
    Log,
    PreviousCalculation,
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
      if (this.calculationsExist) {
        this.getAllCalculations();
      }
    },
    async getAllCalculations() {
      let currentUserId = this.$store.state.currentUser.user_id;
      let calculations = await getAllCalculations(
        currentUserId,
        this.$store.state.jwtToken
      );
      if (calculations.length > 0) {
        this.calculations = calculations.reverse();
      } else {
        this.calculations = calculations;
      }
    },
    async deleteCalculation(id) {
      await deleteCalculation(id, this.$store.state.jwtToken);
      this.calculations = await getAllCalculations(
        this.$store.state.currentUser.user_id,
        this.$store.state.jwtToken
      );
    },
    exitDropDown() {
      this.calculations = [];
    },
  },
  computed: {
    isUserLoggedIn() {
      return this.$store.state.userLoggedIn;
    },
    calculationsExist() {
      return this.calculations.length > 0;
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
  height: 65%;
  margin: 0 auto;
  width: 372px;
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
  border: none;
  background: crimson;
  border-radius: 5px;
  color: white;
  cursor: pointer;
  font-size: 16px;
  font-weight: bold;
  padding: 10px;
  margin: 2rem;
}

.previousCalculationsContainer {
  background: #524a4e;
  max-width: 372px;
  margin: 0 auto;
  padding: 10px 0;
  border-radius: 10px;
  box-shadow: 0 0 16px #363535;
}

.previousCalculations {
  margin-bottom: 5px;
  border-radius: 5px;
}

.row {
  display: grid;
  grid-template-columns: 20% 60%;
  margin: 0 auto;
}
.exitContainer {
  display: flex;
  justify-content: right;
}

#exitDropDown {
  border-radius: 50%;
  font-size: 14px;
  color: white;
  padding: 2px 5px;
  margin-right: 1rem;
  transition: ease-in-out 0.3s;
}
#exitDropDown:hover {
  cursor: pointer;
  opacity: 60%;
}
#deleteContainer {
  color: white;
  padding: 13px 10px 10px;
}
#delete {
  border: solid black 1px;
  border-radius: 50%;
  padding: 10px 15px;
}
#delete:hover {
  background: black;
  cursor: pointer;
}
#delete:hover .previousCalculations {
  transform: scale(1.5);
}
</style>

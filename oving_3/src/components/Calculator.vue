<template>
  <div class="display">{{ current || "0" }}</div>
  <div class="c button" @click="clear">C</div>
  <div class="ans button" @click="showAnswer">ANS</div>
  <div class="del button" @click="deleteOne">DEL</div>
  <div class="plus operator button" @click="add">+</div>
  <div class="one button" @click="append('1')">1</div>
  <div class="two button" @click="append('2')">2</div>
  <div class="three button" @click="append('3')">3</div>
  <div class="subtract operator button" @click="subtract">-</div>
  <div class="four button" @click="append('4')">4</div>
  <div class="five button" @click="append('5')">5</div>
  <div class="six button" @click="append('6')">6</div>
  <div class="multiply operator button" @click="multiply">*</div>
  <div class="seven button" @click="append('7')">7</div>
  <div class="eight button" @click="append('8')">8</div>
  <div class="nine button" @click="append('9')">9</div>
  <div class="divide operator button" @click="divide">/</div>
  <div class="empty button"></div>
  <div class="zero button" @click="append('0')">0</div>
  <div class="point button" @click="appendPoint('.')">.</div>
  <div class="equals button" @click="equal">=</div>
</template>

<script>
import { doCalculation } from "@/utils/apiutils";

export default {
  name: "Calculator",
  data() {
    return {
      previous: null,
      current: "",
      operator: null,
      operatorClicked: false,
      answer: "",
      equation: "",
    };
  },

  methods: {
    addEquations() {
      this.$emit("add-equations", this.equation);
    },
    clear() {
      this.current = "";
    },

    // For testing purposes only
    toNumber() {
      console.log(typeof Number(this.current));
      console.log(Number(this.current));
    },

    append(number) {
      if (this.operatorClicked) {
        this.clear();
        this.operatorClicked = false;
      }
      this.current = this.current + number;
    },
    appendPoint() {
      if (this.current.indexOf(".") === -1) {
        this.append(".");
      }
    },
    savePrevious() {
      this.previous = this.current;
      this.operatorClicked = true;
      this.equation = this.previous;
    },
    addToLog(operation) {
      console.log(typeof this.equation);
      if (this.equation.indexOf("=") === -1 && this.equation !== "") {
        this.equation += operation;
      }
    },
    showAnswer() {
      this.clear();
      this.append(this.answer);
      //this.current = this.answer;
    },
    deleteOne() {
      this.current = this.current.substring(0, this.current.length - 1);
      console.log(this.current);
      console.log(typeof this.current);
    },

    add() {
      this.operator = "+";
      this.savePrevious();
      this.addToLog("+");
    },
    subtract() {
      this.operator = "-";
      this.savePrevious();
      this.addToLog("-");
    },
    multiply() {
      this.operator = "*";
      this.savePrevious();
      this.addToLog("*");
    },
    divide() {
      this.operator = "/";
      this.savePrevious();
      this.addToLog("/");
    },
    async equal() {
      if (
        this.equation.indexOf("+") !== -1 ||
        this.equation.indexOf("-") !== -1 ||
        this.equation.indexOf("*") !== -1 ||
        this.equation.indexOf("/") !== -1
      ) {
        this.equation += this.current;
        const equationObject = {
          first: this.previous,
          operation: this.operator,
          second: this.current,
        };
        console.log(equationObject);

        let currentUserId = this.$store.state.currentUser.userId;
        let calculationResponse = await doCalculation(
          equationObject,
          currentUserId,
          this.$store.state.jwtToken
        );
        console.log("Calculation response: " + calculationResponse.answer);

        this.equation += "=";

        // this.current = String(
        //   this.operator(Number(this.previous), Number(this.current))
        // );

        this.answer = String(calculationResponse.answer);
        this.current = this.answer;
        this.equation += this.answer;
        this.previous = null;
        this.operatorClicked = false;
        //console.log(this.equation);
        this.addEquations();
      }
      this.equation = "";
    },
  },
};
</script>

<style scoped>
.button {
  background-color: rgba(215, 215, 215, 0.96);
  margin: 2px;
  cursor: pointer;
  outline: none;
  border: 2px solid black;
  border-radius: 10px 10px 10px 10px;
  height: 60px;
  text-align: center;
  color: #181818;
  user-select: none;
}

.button:hover {
  background-color: #ffffff;
  justify-content: center;
  align-items: center;
}

.button:active {
  background: #e5e5e5;
  -webkit-box-shadow: inset 0px 0px 5px #c1c1c1;
  -moz-box-shadow: inset 0px 0px 5px #c1c1c1;
  box-shadow: inset 0px 0px 5px #c1c1c1;
  outline: none;
}

.display {
  grid-area: display;
  margin-bottom: 10px;
  background-color: #363535;
  color: white;
  outline: none;
  border: solid black;
  text-shadow: 0 0 17px #363535;
  border-radius: 5px;
}

.operator {
  background-color: rgba(140, 140, 140, 0.96);
}

.operator:hover {
  background-color: rgba(194, 194, 194, 0.96);
}

.c {
  grid-area: c;
}

.ans {
  grid-area: ans;
}

.del {
  grid-area: del;
}

.plus {
  grid-area: plus;
}

.one {
  grid-area: one;
}

.two {
  grid-area: two;
}

.three {
  grid-area: three;
}

.subtract {
  grid-area: subtract;
}

.four {
  grid-area: four;
}

.five {
  grid-area: five;
}

.six {
  grid-area: six;
}

.multiply {
  grid-area: multiply;
}

.seven {
  grid-area: seven;
}

.eight {
  grid-area: eight;
}

.nine {
  grid-area: nine;
}

.divide {
  grid-area: divide;
}

.empty {
  grid-area: empty;
}

.zero {
  grid-area: zero;
}

.point {
  grid-area: point;
}

.equals {
  grid-area: equals;
  background-color: orange;
}

.equals:hover {
  background-color: rgba(255, 165, 0, 0.69);
}
</style>

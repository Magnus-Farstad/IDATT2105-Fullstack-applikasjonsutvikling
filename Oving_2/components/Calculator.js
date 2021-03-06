app.component('calculator', {
    template:
    `
    <div class="display">{{ current || '0'}}</div>
    <div class="c button" @click="clear">C</div>
    <div class="ans button" @click="showAnswer">ANS</div>
    <div class="del button" @click="deleteOne">DEL</div>
    <div class="plus button" @click="add">+</div>
    <div class="one button" @click="append('1')">1</div>
    <div class="two button" @click="append('2')">2</div>
    <div class="three button" @click="append('3')">3</div>
    <div class="subtract button" @click="subtract">-</div>
    <div class="four button" @click="append('4')">4</div>
    <div class="five button" @click="append('5')">5</div>
    <div class="six button" @click="append('6')">6</div>
    <div class="multiply button" @click="multiply">*</div>
    <div class="seven button" @click="append('7')">7</div>
    <div class="eight button" @click="append('8')">8</div>
    <div class="nine button" @click="append('9')">9</div>
    <div class="divide button" @click="divide">/</div>
    <div class="empty button"></div>
    <div class="zero button" @click="append('0')">0</div>
    <div class="point button" @click="appendPoint('.')">.</div>
    <div class="equals button" @click="equal">=</div>
    `,
    data() {
        return {
            previous: null,
            current: "",
            operator: null,
            operatorClicked: false,
            answer: "",
            equation: ''
        }
    },

    methods: {
        addEquations() {
            this.$emit('add-equations', this.equation);
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
            if(this.operatorClicked) {
                this.clear();
                this.operatorClicked = false;
            }
            this.current = this.current + number;
        },
        appendPoint() {
            if(this.current.indexOf(".") === -1) {
                this.append(".");
            }
        },
        savePrevious() {
            this.previous = this.current;
            this.operatorClicked = true;
            this.equation = this.previous;
        },
        addToLog(operation) {
            if(this.equation.indexOf("=") === -1 && this.equation !== "") {
                this.equation += operation;
            }
        },
        showAnswer() {
            this.current = this.answer;
        },
        deleteOne() {
            this.current = this.current.substring(0, this.current.length - 1);
            console.log(this.current);
            console.log(typeof this.current);
        },

        add() {
            this.operator = (x, y) => x + y;
            this.savePrevious();
            this.addToLog("+");
        },
        subtract() {
            this.operator = (x, y) => x - y;
            this.savePrevious();
            this.addToLog("-");
        },
        multiply() {
            this.operator = (x, y) => x * y;
            this.savePrevious();
            this.addToLog("*");
        },
        divide() {
            this.operator = (x, y) => x / y;
            this.savePrevious();
            this.addToLog("/");
        },
        equal() {
            if(this.equation.indexOf("+") !== -1 ||
                this.equation.indexOf("-") !== -1 ||
                this.equation.indexOf("*") !== -1 ||
                this.equation.indexOf("/") !== -1)
            {
                this.equation += this.current;
                let equationSplit = this.equation.split("")
                let equationObject = {
                    first: equationSplit[0],
                    operation: equationSplit[1],
                    second: equationSplit[2],
                }
                console.log(equationObject)
                console.log(this.equation)
                this.equation += "=";

                this.current = String(this.operator(Number(this.previous), Number(this.current)));
                this.answer = this.current;
                this.equation += this.answer;
                this.previous = null;
                //console.log(this.equation);
                this.addEquations();
            }
            this.equation = '';
        }
    }
})
const app = Vue.createApp({
    data() {
        return {
            equations: []
        }
    },
    methods: {
        addEquation(equation) {
            this.equations.push(equation);
            //console.log(equation);
            for(let i = 0; i < this.equations.length; i++) {
                console.log(this.equations[i]);
            }
        }
    }
})

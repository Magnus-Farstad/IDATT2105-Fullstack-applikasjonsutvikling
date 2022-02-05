app.component('log', {
    props: {
        equations: {
            type: Array,
            required: true
        }
    },
    template:
    `
    <div id="scrollBox" class="log">
        <ul id="arrayUnorderedList">
            <li v-for="(equation, index) in equations" :key="index">
                {{ equation }}
            </li>
        </ul>
    </div>
    `,
    methods: {
        addElement() {
            let unorderedList = document.getElementById('arrayUnorderedList');

            let newElement = document.createElement('li');
            let text = document.createTextNode("Test");
            newElement.appendChild(text);

            //newElement.innerHTML = 'New element has been added!';

            unorderedList.appendChild(newElement);
        }
    }
})
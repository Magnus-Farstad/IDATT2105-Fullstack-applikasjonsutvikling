
let count = 0;
let wordArray = ["Hei", "Skole", "Frukt", "Ord",
"Kjøttboller"];
let currentWordIndex = 0;

function buttonOnePressed(button) {
    count++;
    button.innerHTML = count;

    if(count === 10) {
        alert("You have pressed the button 10 times!");
    }
    if(count === 30) {
        alert("You have found an easter egg!!!!");
    }
}

function hideContent(elementId) {
    let footer = document.getElementById(elementId);
    if(footer.innerHTML !== "") footer.innerHTML = "";
    else footer.innerHTML = "This is a footer.";
}

function showArray() {
    if(currentWordIndex < wordArray.length) {

        let l1 = document.createElement("li");
        let text;
        text = document.createTextNode(wordArray[currentWordIndex]);


        l1.appendChild(text);
        document.getElementById("arrayUnorderedList").appendChild(l1);

        if(currentWordIndex === 0) {
            alert("Keep pressing the button" +
                " to reveal more items!")
        }

        currentWordIndex++;
    } else alert("You have found every element in the array");
}
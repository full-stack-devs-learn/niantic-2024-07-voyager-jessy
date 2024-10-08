let service;
let list = []
let itemName;
let itemNameError;
let itemQuantityError;
let itemQuantity;

let allItemsIncomplete = true;


function displayListTitle() {
    const title = document.getElementById("title")
    title.textContent = service.getListName();
}


function displayShoppingList() {
    const parent = document.getElementById("shopping-list")

    list.forEach(item => {
        addListItem(item, parent);
    })
}

function addListItem(item, parent)
{
    const div = document.createElement("div")
    div.classList.add("list-item");
    
    if(item.isComplete)
    {
        div.classList.add("complete")
    }

    addItemTitle(item, div);
    addQuantity(item, div)

    parent.appendChild(div)

}

function addItemTitle(item, parent)
{
    const div = document.createElement("div")
    div.textContent = item.title;


    parent.appendChild(div);
}

function addQuantity(item, parent)
{
    const div = document.createElement("div");
    div.classList.add("quantity-container");

    const span = document.createElement("span");
    span.textContent = "quantity"
    span.classList.add("super");

    const text = document.createTextNode(item.quantity)

    div.appendChild(span)
    div.appendChild(text)

    parent.appendChild(div);
}


//mark all completed - make sure you address allItemsIncomplete when you do this~!
function markCompleted() {
    const listItems = document.querySelectorAll(".list-item");

    listItems.forEach(item => {
        
        if (allItemsIncomplete){
            item.classList.add("complete");
            allItemsIncomplete = !allItemsIncomplete;
        }
        else {
            item.classList.toggle("complete");
        }    
       
        })
}

//single line item marked complete
function markItemComplete(event){
const item = event.target; 

        if(!item.classList.contains('complete')){
            item.classList.add("complete");
        }
        // else{
        //     item.classList.remove("complete");
        // }
//forgot we needed to have dblclick according to README but just so i know, this is another way to add the logic for removing complete class to list   
}

function displayAddedItem(item){
    const parent = document.getElementById("shopping-list");

    addListItem(item, parent);
}

function setUpValidation()
{
    nameInput = document.getElementById("itemName");
    quantityInput = document.getElementById('quantity');
}


function submitItems(event){
    event.preventDefault();

    if(nameInput.validity.valid && quantityInput.validity.valid){

        const name = document.getElementById('itemName').value;
        const quantityInput = document.getElementById("quantity").value;

        const item = {
            title: name,
            quantity: quantityInput
        }
//add it to the list
        list.push(item);

        // display it
        const parent = document.getElementById("shopping-list");
        addListItem(item, parent);


        //clear the form 
        clearForm();

    }
}

function clearForm()
{
    document.getElementById("itemName").value = "";
    document.getElementById("quantity").value = "";
}


// create the page load event here

document.addEventListener("DOMContentLoaded", () => {
    service = new ShoppingService();
    list = service.getShoppingList();

    displayListTitle();
    displayShoppingList();
    setUpValidation();

    //mark all items complete
    const button = document.getElementById('allCompleteButton')
    button.addEventListener('click', markCompleted); 
    

    //individual items to complete
    const listItems = document.querySelector(".list-item");
    listItems.addEventListener('click', markItemComplete);
    listItems.addEventListener('dblclick', ()=>
        listItems.classList.toggle('complete'));
   


    //adding item from form input
    const form = document.getElementById('form-item');
    form.addEventListener('submit', submitItems)


});


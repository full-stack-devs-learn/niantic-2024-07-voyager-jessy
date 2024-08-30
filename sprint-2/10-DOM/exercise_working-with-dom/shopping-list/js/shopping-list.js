// add pageTitle

// add groceries
const service = new ShoppingService();
/**
 * This function will get a reference to the title and set its text to the value
 * of the pageTitle variable that was set above.
 */
function displayListTitle() {
    const shoppingTitle = document.getElementById("title");
    shoppingTitle.textContent = service.getListName();

}

/**
 * This function will loop over the array of groceries that was set above and add them to the DOM.
 */
function displayGroceries() {
    const lists = service.getShoppingList()
                        // .sort((need,done) => !need.markCompleted - done.markCompleted);

    const listContainer = document.getElementById("groceries");

    lists.forEach(list => {
        createListDiv(list, listContainer)
    });

}

/**
 * i added this one to create a new row for each line item, will go 
/back to figure out how to do this within the display grogeries function 
as soon as I am confident I can get this working
*/
function createListDiv(list, parent){

    //create new variable to rep the new line item we are making for each item on the shopping list
    const listDiv = document.createElement("div");

    //add each item to this new class list
    listDiv.classList.add("groceries");

    parent.appendChild(listDiv);

    //add all the inner divs here 
    buildItemTitle(list, parent);
    

}

function buildItemTitle(list, parent){
    const titleDiv = document.createElement('div');
    titleDiv.classList.add("list-item");
    titleDiv.textContent = list.title;

    parent.appendChild(titleDiv);

    buildItemQuantity(list, titleDiv);

}

function buildItemQuantity(list, parent){
    const quantityDiv = document.createElement('div');
    quantityDiv.classList.add("quantity-container");


    const quantityLabel = document.createElement('span');
    quantityLabel.classList.add('super');
    quantityLabel.textContent = "quantity";
    quantityDiv.appendChild(quantityLabel);

    const quantityTitle = document.createTextNode(list.quantity);
    quantityDiv.appendChild(quantityTitle);
    document.body.appendChild(quantityDiv);
    

    
    parent.appendChild(quantityDiv);

}


/**
 * This function will be called when the button is clicked. You will need to get a reference
 * to every list item and add the class completed to each one
 */
function markCompleted() {
}

document.addEventListener("DOMContentLoaded" , () => {

    displayListTitle();
    displayGroceries();



})



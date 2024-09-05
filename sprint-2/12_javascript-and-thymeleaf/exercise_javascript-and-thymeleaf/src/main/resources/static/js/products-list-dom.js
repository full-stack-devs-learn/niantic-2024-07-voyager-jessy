document.addEventListener("DOMContentLoaded", () =>{

loadPage();
displayProduct();
//changeCategory();
fetch(`/products/pages`).then(response => response.text()).then(data => {
totalPages = +data});



})



function changeCategory()
{
const selectedCategory = document.getElementById("category");
const productsView = document.getElementById("products-container");

selectedCategory.addEventListener("change", () => {
    const catId = document.getElementById("category").value;
    const url = `products/category/${catId}`;

    fetch(url)
        .then(response => response.json())
        .then(data => {
            productsView.innerHTML = ""

            data.forEach(product => {
            displayProduct(product, productsView)
            })
        })
        .catch(error => {
                console.log(error);
        });
})


function displayProduct(product, table){
//create display parts
const row = document.createElement('tr');
const ids = document.createElement('td');
const names = document.createElement('td');
const prices = document.createElement('td');
const buttons = document.createElement('td');

//direct what will be within each display part
ids.textContent = product.productId;
names.textContent = product.productName;
prices.textContent = product.unitPrice;

//create edit button
const editProduct = document.createElement('a');
editProduct.classList.add('btn');
editProduct.classList.add('btn-success');
editProduct.textContent= "Edit";
editProduct.href = `/products/${product.productId}/edit`

//create delete button
const deleteProduct = document.createElement('a');
deleteProduct.classList.add('btn');
deleteProduct.classList.add('btn-danger');
deleteProduct.textContent= "Delete";
deleteProduct.href = `/products/${product.productId}/delete`;

//populate delete buttons into button variable
buttons.appendChild(editProduct);
buttons.appendChild(deleteProduct);

//add all into the row element
row.appendChild(ids);
row.appendChild(names);
row.appendChild(prices);
row.appendChild(buttons);

//now add all into the table that is identified within the function that displayProducts is called in
table.appendChild(row);








}



}
function loadPage()
{
    const container = document.getElementById("products-container");
    container.innerHTML = "";

    const url = 'products'

    //doing it asynchronous so that it does mutli things at once and not leave us hanging
    //for forever while it all loads one by one.
    fetch(url).then(response =>{
//        if(response.status === 200){
        return response.text()
//        }
//        throw new Error(response);
    }).then(data => {
        container.innerHTML = data
        }).catch(error => {
                  console.log(error)
              })

        .catch(error => {});



}



document.addEventListener("DOMContentLoaded", () => {

const addProduct = document.getElementById("add-product");
const productName = document.getElementById("productName");
const categoryId = document.getElementById("categoryId");
const quantity = document.getElementById("quantityPerUnit");
const unitPrice = document.getElementById("unitPrice");
const unitStock = document.getElementById("unitsInStock");
const reorderLevel = document.getElementById("reorderLevel");


productName.addEventListener("input", () => {
    addProduct.classList.remove("was-validated");
});

categoryId.addEventListener("input", () =>{
    addProduct.classList.remove("was-validated");
})

quantity.addEventListener("input", () =>{
    addProduct.classList.remove("was-validated");
})
unitPrice.addEventListener("input", () =>{
    addProduct.classList.remove("was-validated");
})

reorderLevel.addEventListener("input", () =>{
    addProduct.classList.remove("was-validated");
})





})




let categoryService;
let productService;
let addFormScreen;
let addForm;

document.addEventListener("DOMContentLoaded", function() {
    categoryService = new CategoryService();
    productService = new ProductsService();

    addFormScreen = document.getElementById("add-form-screen");
    addForm = document.getElementById("add-form");

    document.getElementById("add-button").addEventListener("click", showForm);
    document.getElementById("cancel-button").addEventListener("click", cancelAdd);
    document.getElementById("save-button").addEventListener("click", addCategory);

    loadProducts();
})

function loadProducts()
{
    // load all products
    productService.getProductsByCategory(categoryId)
        .then(products => {
            const productsContainer = document.getElementById('categories-container');
            productsContainer.innerHTML = '';

            products.forEach(product => {
                const template = document.getElementById("category-template").contentEditable.cloneNode(true);
                template.getElementById("category-header").innerText = product.productName;
                template.getElementById("category-body")
                
            });

            
            
        })
}

function showForm()
{
    addFormScreen.classList.remove("d-none");
}

function cancelAdd(event)
{
    event.preventDefault();
    addFormScreen.classList.add("d-none");
}

function addCategory(event)
{
    event.preventDefault();
    event.stopPropagation()

    addForm.classList.add("was-validated");

    if(addForm.checkValidity()){

        addFormScreen.classList.add("d-none");
        addForm.classList.remove("was-validated");
    }
}
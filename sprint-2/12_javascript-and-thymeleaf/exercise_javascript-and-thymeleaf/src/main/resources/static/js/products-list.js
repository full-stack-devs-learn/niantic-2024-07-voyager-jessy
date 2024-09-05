let pageNumber = 1;
let totalPages = 1;
let currentPage;



document.addEventListener("DOMContentLoaded", () => {

    const buttons = document.getElementById("pagination");
//identify all my page buttons

    const first = document.getElementById("firstPage");
    const previous = document.getElementById("previous");
    const one = document.getElementById("page1");
    const two = document.getElementById("page2");
    const next = document.getElementById("next");
    const last = document.getElementById("lastPage");

//add classes to buttons for beautification
    first.classList.add("page-link");
    previous.classList.add("page-link");
    one.classList.add("page-link");
    two.classList.add("page-link");
    next.classList.add("page-link");
    last.classList.add("page-link");

//button logic eventListener
    first.addEventListener("click", () => {
        if(pageNumber > 1) {
            pageNumber= 1
            loadPage();
        }

    })

    previous.addEventListener("click", () => {
        if(pageNumber > 1) {
            pageNumber--;
            loadPage();

        }

    })

    one.addEventListener("click", () =>{
        if(pageNumber > 1) {
                pageNumber= 1
                loadPage();
            }
    })

    two.addEventListener("click", () =>{
        if(pageNumber !== 2) {
        pageNumber = 2;
        loadPage();
        }
    })

    next.addEventListener("click", () =>{
        if(pageNumber < totalPages) {
            pageNumber++;
            loadPage();
        }
    })

    last.addEventListener("click", () =>{
        if(pageNumber < totalPages) {
            pageNumber = totalPages
            loadPage();
        }
    })


    fetch(`api/products/pages`)
        .then(response => response.text())
        .then(data => {
        totalPages = +data});
        updatePageBtn();

    loadPage();
})

function loadPage(){

    const categoryOption = document.getElementById("category");
    categoryOption.addEventListener("change", () =>{

        const container = document.getElementById("products-container");
        container.innerHTML = "";

        const catId = categoryOption.value;
        const url = `/products/category/${catId}`;


        fetch(url).then(response => {
            if(response.status === 200)
            {
                return response.text();
            }
            throw new Error(response);
                }).then(data => {
                    container.innerHTML = data;
                    updatePageBtn;
                }).catch(error => {
                    console.log("Error in fetching products:", error)
                });
            })

}

function updatePageBtn(){
const buttons = document.querySelectorAll(".page-link");
buttons.forEach(btn => btn.classList.remove("active"));
//reset all pages to nonactive

document.querySelector(`#page${pageNumber}`).classList.add("active");


}

let peopleService;
let currentPage = 1;
const totalPages = 5; //per swapi api while displaying 20 characters, there will be a total of 5 pages


document.addEventListener("DOMContentLoaded", function(){
    peopleService = new PeopleService();

    loadPeople(currentPage);

})



function loadPeople(pageNumber)
{
    peopleService.getAllPeopleByPage(pageNumber)
    .then(response => {
        const people = response.results;
        const nextLink = response.next;
        const url = response.url;

        const header = document.getElementById("title");
        header.textContent = "Star Wars Characters";
        header.classList.add("text-center", "text-info")

        
        const peopleNames = document.getElementById("peoples-container");
        peopleNames.innerHTML = "";

        people.forEach(person => {
            const li = document.createElement("li")
            li.classList.add("list-group-item", "d-flex", "justify-content-between", "align-items-center")
            li.textContent = person.name;
            
            //possible add
            const link = document.createElement("a");
            link.className = "page-link";
            link.href = "#"
            link.href = person.url;
            link.innerHTML = "details";



            link.addEventListener("click", function(event){
                preventDefault();
                loadDetails(uid);
            })

            li.appendChild(link);
            //end possible add
            peopleNames.appendChild(li);
        });

        setupPagination(totalPages, pageNumber);

        console.log(nextLink);
        console.log(people);
    })

    function setupPagination(totalPages, currentPage){
        const pageNumberContainer = document.getElementById("pagination-container");
        const pageList = pageNumberContainer.querySelector(".pagination")
        pageList.classList.add("mx-auto");
        pageList.innerHTML = "";

         //previous button
         const previousPage = document.createElement("li");
         previousPage.className = "page-item";
         const previousLink = document.createElement("a");
         previousLink.className = "page-link";
         previousLink.href = "#";
         previousLink.innerHTML = "&laquo;";
 
         previousLink.addEventListener("click", function(event){
             event.preventDefault();
             if(currentPage > 1){
                 loadPeople(currentPage - 1);
             }
         });
         previousPage.appendChild(previousLink);
         pageList.appendChild(previousPage);


        //page numbers 
        for(let i=1; i<=totalPages; i++){
            const pageItem = document.createElement("li");
            pageItem.className = "page-item" + (i === currentPage ? " active" : "");
            const pageLink = document.createElement("a");
            pageLink.className = "page-link";
            pageLink.href = "#";
            pageLink.textContent = i;

            pageLink.addEventListener("click", function(event) {
                event.preventDefault();
                currentPage = i;
                loadPeople(currentPage);

            });
            pageItem.appendChild(pageLink);
            pageList.appendChild(pageItem);
        }


        //next button
        const nextPage = document.createElement("li");
        nextPage.className = "page-item";
        const nextLink = document.createElement("a");
        nextLink.className = "page-link";
        nextLink.href = "#";
        nextLink.innerHTML = "&raquo;";

        nextLink.addEventListener("click", function(event){
            event.preventDefault();
            if(currentPage < totalPages){
                loadPeople(currentPage + 1)
            }

        })
        nextPage.appendChild(nextLink);
        pageList.appendChild(nextPage);


        }

        function loadDetails(uid){
            const params = new URLSearchParams(window.location.search);
            return params.get('uid')   
            
            peopleService.getDetailsByPeopleUid(uid);

        
        }

    




}


let peopleService;
let currentPage = 1;
const totalPages = 5; //per swapi api while displaying 20 characters, there will be a total of 5 pages


document.addEventListener("DOMContentLoaded", function () {
    peopleService = new PeopleService();

    loadPeople(currentPage);

})



function loadPeople(pageNumber) {
    
    try{

   
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
                const uid = person.uid;
                // link.href = person.url;
                link.innerHTML = "details";

                link.addEventListener("click", function (event) {
                    event.preventDefault();
                    loadDetails(person.uid);
                })

                li.appendChild(link);
                //end possible add
                peopleNames.appendChild(li);
            });

            setupPagination(totalPages, pageNumber);

            console.log(nextLink);
            console.log(people);
      
        })
    }
    catch(error)
    {
        console.log(error);
    }
}
        

    function setupPagination(totalPages, currentPage) {
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

        previousLink.addEventListener("click", function (event) {
            event.preventDefault();
            if (currentPage > 1) {
                loadPeople(currentPage - 1);
            }
        });
        previousPage.appendChild(previousLink);
        pageList.appendChild(previousPage);


        //page numbers 
        for (let i = 1; i <= totalPages; i++) {
            const pageItem = document.createElement("li");
            pageItem.className = "page-item" + (i === currentPage ? " active" : "");
            const pageLink = document.createElement("a");
            pageLink.className = "page-link";
            pageLink.href = "#";
            pageLink.textContent = i;

            pageLink.addEventListener("click", function (event) {
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

        nextLink.addEventListener("click", function (event) {
            event.preventDefault();
            if (currentPage < totalPages) {
                loadPeople(currentPage + 1)
            }

        })
        nextPage.appendChild(nextLink);
        pageList.appendChild(nextPage);

    }

    function getUidFromUrl() {
        const params = new URLSearchParams(window.location.search);
        return params.get('uid')

    }

    function loadDetails(uid) {

        const peoplesContainer = document.getElementById("peoples-container");
        peoplesContainer.classList.add("d-none");

        peopleService.getDetailsByPeopleUid(uid)
            .then(person => {
                console.log("Name: ", person.name);
                console.log(person);

                const detailsContainer = document.getElementById("details-container");
                detailsContainer.innerHTML = "";

               
                    const characterName = document.createElement("h2");
                    characterName.classList.add("text-center", "card")
                    characterName.innerText = person.name;

                    const characterDob = document.createElement("li");
                    characterDob.classList.add("list-group-item", "d-flex", "justify-content-between", "align-items-center");
                    characterDob.innerText = "Birth Date: " + person.birth_year;

                    const eyeColor = document.createElement("li")
                    eyeColor.classList.add("list-group-item", "d-flex", "justify-content-between", "align-items-center");
                    eyeColor.innerText = "Eye Color: " + person.eye_color

                    const mass = document.createElement("li")
                    mass.classList.add("list-group-item", "d-flex", "justify-content-between", "align-items-center");
                    mass.innerText = "Eye Color: " + person.mass

                

                detailsContainer.appendChild(characterName);
                detailsContainer.appendChild(characterDob);
                detailsContainer.appendChild(eyeColor);

            })
            .catch(error => {
                console.error("Error fetching details:", error)
            })


    }









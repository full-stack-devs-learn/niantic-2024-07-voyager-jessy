import { useState } from "react"
import { Link, useLocation } from "react-router-dom";

export default function CategoriesList()
{


// const location = useLocation();
// const params = new URLSearchParams(location.search)





return(
    <>

        <h4>Categories List</h4>
        <Link className="btn btn-success">Add</Link>
        <ul>
            <li><Link to={'/categories/1'}>Category 1</Link></li>
            <li><Link to={'categories/2'}> Category 2</Link></li>
            <li>Showing right page</li>
        </ul>
    </>
)

}
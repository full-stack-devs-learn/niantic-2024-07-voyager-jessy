import { useState } from "react"
import { Link, useLocation } from "react-router-dom";

export default function CategoriesList() {


    // const location = useLocation();
    // const params = new URLSearchParams(location.search)





    return (
        <>

            <h1>Categories List</h1>
            <Link className="btn btn-success" to={"/categories/add"}>Add</Link>
            <ul>
                <li className="card mt-3"><Link to={'/categories/1'}>Category 1</Link>
                    <Link to={"/categories/:categoryId/edit"}>Edit</Link></li>
                <li className="card mt-3"><Link to={'/categories/2'}> Category 2</Link>
                    <Link to={"/categories/edit"}>Edit</Link></li>
                <li className="card mt-3"><Link to={'/categories/3'}> Category 3</Link>
                    <Link to={"/categories/:categoryId/edit"}>Edit</Link></li>
                <li className="card mt-3"><Link to={'/categories/4'}> Category 4</Link>
                    <Link to={"/categories/:categoryId/edit"}>Edit</Link></li>
                <li className="card mt-3"><Link to={'/categories/5'}> Category 5</Link>
                    <Link to={"/categories/:categoryId/edit"}>Edit</Link></li>
                <li className="card mt-3"><Link to={'/categories/6'}> Category 6</Link>
                    <Link to={"/categories/:categoryId/edit"}>Edit</Link></li>
                <li className="card mt-3"><Link to={'/categories/7'}> Category 7</Link>
                    <Link to={"/categories/:categoryId/edit"}>Edit</Link></li>
                <li className="card mt-3"><Link to={'/categories/8'}> Category 8</Link>
                    <Link to={"/categories/:categoryId/edit"}>Edit</Link></li>
               
            </ul>

        </>
    )

}
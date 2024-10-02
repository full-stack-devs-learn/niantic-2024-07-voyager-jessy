import { useState } from "react";
import categoryService from "../../../services/category-service";

export default function CategoryAdd() {

    const [categoryName, setCategoryName] = useState("");
    const [description, setDescription] = useState("")

    async function categoryAddHandler(event:any){

        event.preventDefault();

        const newCategory = {
            categoryName: categoryName,
            description: description
        }

        await categoryService.addCategory(newCategory)
    }
    return (
        <>
                <h4>Add New Category</h4>
                <form onSubmit={categoryAddHandler}> 
                <div className="row">
                    <label htmlFor="category-name">Category Name:</label>
                    <input type="text" className="form-control" name="category-name" id="category-name"
                    onChange={(e) => setCategoryName(e.target.value)}></input>
                </div>
                <div className="row">
                    <label htmlFor="description">Description</label>
                    <input className="form-control mb-3" name="description" id="description"
                    onChange={(e) => setDescription(e.target.value)}/>
                </div>
                <button className="btn btn-outline-danger mr-3" type="submit">Add Category</button>
            </form>

        
        </>
    
    
    )
}
import { useParams } from "react-router-dom";

export default function CategoryEdit() {

    const { categoryId } = useParams();
    




    return (
        <>
            <h4>Edit Category</h4>
            <p>Category Id: {categoryId}</p>
            <form>    
                <div className="row">
                    <label htmlFor="category-name">Category Name:</label>
                    <input type="text" className="form-control" name="category-name" id="category-name"
                    // onChange={(e) => setCategoryName(e.target.value)}
                    ></input>
                </div>
                <div className="row">
                    <label htmlFor="description">Description</label>
                    <input className="form-control mb-3" name="description" id="description"
                    // onChange={(e) => setDescription(e.target.value)}
                    />
                </div>
                <button className="btn btn-outline-danger mr-3" type="submit">Add Category</button>
            </form>
        </>
    )
}
export default function CategoryAdd() {
    return (
        <>
                <h4>Add New Category</h4>
                <form> 
                <div className="row">
                    <label htmlFor="product-name">Category Name:</label>
                    <input type="text" className="form-control" name="product-name" id="product-name"></input>
                </div>
                <div className="row">
                    <label htmlFor="product-price">Description</label>
                    <input className="form-control mb-3" name="product-price" id="product-price"/>
                </div>
                <button className="btn btn-outline-danger mr-3" type="submit">Add Category</button>
            </form>

        
        </>
    
    
    )
}
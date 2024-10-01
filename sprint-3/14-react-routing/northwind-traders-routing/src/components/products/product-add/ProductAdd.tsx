export default function ProductAdd()
{
    return(
        <>
            <h4>Add New Product</h4>
            <form> 
                <div className="row">
                    <label htmlFor="product-name">Product Name:</label>
                    <input type="text" className="form-control" name="product-name" id="product-name"></input>
                </div>
                <div className="row">
                    <label htmlFor="product-price">Unit Price:</label>
                    <input className="form-control" name="product-price" id="product-price"/>
                </div>
                <div className="row">
                    <label htmlFor="product-quantity">Quantity per unit:</label>
                    <input className="form-control" name="product-quantity" id="product-quantity"/>
                </div>
                <div>
                    <label htmlFor="product-category-id">Category select</label>
                    <select className="form-select mb-2" id="product-category-id-select">
                        <option className="diabled">Select Category</option>
                        <option>1</option>
                        <option>2</option>
                        <option>3</option>
                        <option>4</option>
                        <option>5</option>
                        <option>6</option>
                        <option>7</option>
                        <option>8</option>
                    </select>
                </div>
                <button className="btn btn-outline-danger mr-3" type="submit">Add Product</button>
            </form>

        
        
        
        </>
    )
}
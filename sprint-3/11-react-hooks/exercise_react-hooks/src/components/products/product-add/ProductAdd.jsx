import productService from "../../../services/product-service";
import { useState } from "react";

export default function ProductAdd({ onProductAdded }) {
    const [productName, setProductName] = useState('');
    const [productCategoryId, setProductCategoryId] = useState('');
    const [productQuantity, setProductQuantity] = useState('');
    const [productPrice, setProductPrice] = useState('');



    async function addProductHandler(event)
    {
        event.preventDefault()

        const newProduct = {
            name: productName,
            unitPrice: productPrice,
            categoryId: productCategoryId,
            quantityPerUnit: productQuantity
        
        }

        await productService.addProduct(newProduct);

        onProductAdded();
    }





    return (

        <div className="container">
            <h2>Add New Product</h2>
            <form onSubmit={addProductHandler}>
                <div className="row">
                    <label htmlFor="product-name">Product Name:</label>
                    <input type="text" className="form-control" name="product-name" id="product-name"
                        onChange={(e) => setProductName(e.target.value)}
                    />
                </div>

                <div className="row">
                    <label htmlFor="product-price">Unit Price:</label>
                    <input className="form-control" name="product-price" id="product-price"
                        onChange={(e) => setProductPrice(e.target.value)} />
                </div>
                <div className="row">
                    <label htmlFor="product-quantity">Quantity per unit:</label>
                    <input className="form-control" name="product-quantity" id="product-quantity"
                        onChange={(e) => setProductQuantity(e.target.value)} />
                </div>
                <div>
                    <label htmlFor="product-category-id">Category select</label>
                    <select class="form-select mb-2" id="product-category-id-select" onChange={(e) => setProductCategoryId(e.target.value)} >
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
                <button className="btn btn-danger mr-3" type="submit">Add Category</button>
                {/* <button className="btn btn-dark" type="cancel" onClick={onCancel}>Cancel</button> */}
            </form>
        </div>



    )




}
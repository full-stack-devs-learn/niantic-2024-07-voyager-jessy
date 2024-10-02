import { useState } from "react"
import { Product } from "../../../models/products"
import productService from "../../../services/product-service";
import { useNavigate } from "react-router-dom";

export default function ProductAdd()
{
   
    const [productName, setProductName] = useState("");
    const [unitPrice, setUnitPrice] = useState(+"");
    const [quantityPerUnit, setQuantityPerUnit] = useState("");
    const [categoryId, setCategoryId] = useState(+"")

    const navigate = useNavigate();


    async function productAddHandler(event:any)
    {
        event.preventDefault();

        const newProduct = {
            productName: productName,
            unitPrice: unitPrice,
            quantityPerUnit: quantityPerUnit,
            categoryId: categoryId
        }


        await productService.addProduct(newProduct).then(response => {
            console.log('item added:', response.name);
        });
    }

    return(
        <>
            <h4>Add New Product</h4>
            <form  onSubmit={productAddHandler}> 
                <div className="row">
                    <label htmlFor="product-name">Product Name:</label>
                    <input type="text" className="form-control" name="product-name" id="product-name"
                    onChange={(e) => setProductName(e.target.value) }></input>
                </div>
                <div className="row">
                    <label htmlFor="unit-price">Unit Price:</label>
                    <input className="form-control" name="unit-price" id="unit-price"
                    onChange={(e) => setUnitPrice(+e.target.value)}/>
                </div>
                <div className="row">
                    <label htmlFor="quantity-per-unit">Quantity per unit:</label>
                    <input className="form-control" name="quantity-per-unit" id="quantity-per-unit"
                    onChange={(e) => setQuantityPerUnit(e.target.value)}/>
                </div>
                <div>
                    <label htmlFor="product-category-id">Category select</label>
                    <select className="form-select mb-2" id="product-category-id-select"
                    onChange={(e) => setCategoryId(+e.target.value)}>
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
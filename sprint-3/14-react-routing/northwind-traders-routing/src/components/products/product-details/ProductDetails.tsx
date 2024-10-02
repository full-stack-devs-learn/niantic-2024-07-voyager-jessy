import { useEffect, useState } from "react";
import { useParams } from "react-router-dom"
import { Product } from "../../../models/products";
import productService from "../../../services/product-service";

export default function ProductDetails() {

    const [product, setProduct] = useState<Product>();


    const params = useParams();
    const id = params.id ?? 0;
    


    async function loadProduct()
    {
        const product = await productService.getProductByProductId(+id)
        setProduct(product);
    }

    useEffect(() => {loadProduct()}, [])

    return (
        <>
            <h4>Product Details</h4>
            <div className="card bg-secondary mb-3">
                <div className="card-header">Product Id: {product?.id}</div>
                <div className="card-body">
                    <h4 className="card-title">Product Name: {product?.name}</h4>
                    <p className="card-text">Category id: {product?.categoryId}</p>
                    <p className="card-text">Quantity Per Unit: {product?.quantityPerUnit}</p>
                    <p className="card-text">Unit Price: {product?.unitPrice}</p>
                </div>
            </div>
        </>
    )
}
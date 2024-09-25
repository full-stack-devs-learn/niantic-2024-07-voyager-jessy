import ProductCard from '../product-card/ProductCard'
import './ProductCardContainer.css'
import productService from '../../../services/product-service'
import { useEffect, useState } from 'react'



export default function ProductCardContainer(){

    const [products, setProducts] = useState([])

    useEffect(() => {
        productService.getAllProducts().then(data => {

            console.log("data being returned:");
            console.log(data);
            
        })
        },
    
    [])

   

    return(
        <>
        <h5 className="container"> Products:</h5>
        <main className="container mt-4 products-container" id="products-container">
        {/* {
            products.map((product) => (
                <ProductCard key={product.categoryId} 
                    product={product.productName} 
                    id={product.productId}
                    ></ProductCard>
            ))
        } */}
        </main>
        
        </>

    )



}
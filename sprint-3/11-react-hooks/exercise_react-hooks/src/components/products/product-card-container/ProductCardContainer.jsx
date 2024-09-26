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
            setProducts(data);
            
        })
        },
    
    [])

   

    return(
        <>
        {/* <h5 className="container"> Products:</h5> */}
        <main className="container mt-4 products-container" id="products-container">
        {
            products.map((product) => (
                <ProductCard key={product.productId} 
                    product={product.name} 
                    id={product.id}
                    price={product.unitPrice}
                    ></ProductCard>
            ))
        }
        </main>
        
        </>

    )



}
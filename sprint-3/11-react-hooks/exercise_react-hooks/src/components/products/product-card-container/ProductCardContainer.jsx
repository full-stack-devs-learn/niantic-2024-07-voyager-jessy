import { useEffect, useState } from 'react'
import ProductCard from '../product-card/ProductCard'
import './ProductCardContainer.css'
import productService from '../../../services/product-service'



export default function ProductCardContainer()
{

    const [products, setProducts] = useState([])

    useEffect(() => {
        productService.getAllProducts().then(data => {

            console.log("data being returned:");
            console.log(data);
            setProducts(data);
            
        })
        },
    
    [])

    const productDeleted = (id) => { //acknowledges product up for deletion
        console.log(products);
        const updatedList = products.filter(product => product.id !== id); //created a newly updated product list of all current products that do NOT match the id of product up for deletion
        setProducts(updatedList); //creates this newly updated list of current products
        console.log(updatedList);
    }

   

    return(
        <>
        <div className='container'>
        <main className="container mt-4 products-container" id="products-container">
        {
            products.map((product) => (
                <ProductCard key={product.id} 
                    product={product.name} 
                    id={product.id}
                    price={product.unitPrice}
                    categoryId={product.categoryId}
                    onProductDeleted={productDeleted}
                    ></ProductCard>
            ))
        }
        </main>
        </div>
        
        </>

    )



}
import { useEffect } from 'react'
import './ProductsList.css'
import productService from '../../../services/product-service'

export default function ProductsList({categoryId})
{
    useEffect(() => {
        productService.getProductsByCategory(categoryId).then(data => {
            console.log("data being returned")
            console.log(data);
            
        })


    })

    // productsByCategory()
    // call the products api - getProductsByCategoryId
    return (
        <>
        {(categoryId == 0) 
        ? <div>No Category Selected</div>
        : <h3>
                Products for category: {categoryId}
          </h3>
        }
        </>
    )
}
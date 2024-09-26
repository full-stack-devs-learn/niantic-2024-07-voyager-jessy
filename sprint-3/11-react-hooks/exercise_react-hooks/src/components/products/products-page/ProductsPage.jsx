import './ProductsPage.css'
import ProductCardContainer from '../product-card-container/ProductCardContainer'
import ProductAdd from '../product-add/ProductAdd'
import { useState } from 'react'

export default function ProductsPage() {
    const [action, setAction] = useState("list")

    return (
        <div className='container'>
            <header className='mt-4'>
                <h1>Products</h1>
            </header>
            <button className='btn btn-dark' onClick={() => setAction("add")}>Add</button>

            {action === "list" && <ProductCardContainer></ProductCardContainer>}
            {action === "add" && <ProductAdd onProductAdded={() => setAction("list")}></ProductAdd>}

        </div>
    )
}
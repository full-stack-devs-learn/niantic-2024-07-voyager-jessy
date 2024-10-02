import { useEffect, useState } from "react";
import { Link, useLocation } from "react-router-dom"
import { Product } from "../../../models/products";
import productService from "../../../services/product-service";
import './product-search.css'

export default function ProductSearch() {

    const [products, setProduct] = useState<Product[]>([]);

    useEffect(() => { loadProducts() }, [])


    const location = useLocation();
    //read url for search property
    const queryParams = new URLSearchParams(location.search);

    const minPrice = queryParams.get("minPrice");
    const maxPrice = queryParams.get("maxPrice");
    const name = queryParams.get("name");
    const catId = queryParams.get("catId");

    async function loadProducts() {
        const products = await productService.getAllProducts();
        console.log("products:")
        console.log(products)
        
        setProduct(products);

    }



    return (
        <>
            <Link to={"/products/add"} className="btn btn-outline-success mb-3">Add</Link>

            <h1>Product Search:</h1>
            <form className="d-flex">
                <input className="form-control me-sm-2" type="search" placeholder="Search Products" />
                <button className="btn btn-secondary my-2 my-sm-0" type="submit">Search</button>
            </form>
            <div className="card mt-3">
                <div>Min Price: {minPrice}</div>
                <div>Max Price: {maxPrice}</div>
                <div>Product Name: {name}</div>
                <div>Category Id: {catId}</div>
            </div>
            <div className="product-container">
                {
                    products.map((product: Product) => (
                        <div className="card product-card mt-3" key={product.id}>
                            <h5><Link to={`/products/${product.id}`} className="product-header mt-3">{product.name}</Link></h5>
                            <div id="product-body" className="card-body">
                            </div>
                            <Link to={`/products/${product.id}/edit`} className="btn btn-outline-warning">Edit</Link>

                        </div>

                    ))
                }
            </div>

            {/* <ul>
                <li className="card mt-3"><Link to="/products/1">Product 1</Link>
                    <Link to={"/products/1/edit"}>Edit</Link></li>
                <li className="card mt-3"><Link to="/products/2">Product 2</Link>
                    <Link to={"/products/2/edit"}>Edit</Link></li>
                <li className="card mt-3"><Link to="/products/3">Product 3</Link>
                    <Link to={"/products/3/edit"}>Edit</Link></li>
                <li className="card mt-3"><Link to="/products/3">Product 4</Link>
                    <Link to={"/products/:productId/edit"}>Edit</Link></li>


            </ul> */}



        </>
    )
}
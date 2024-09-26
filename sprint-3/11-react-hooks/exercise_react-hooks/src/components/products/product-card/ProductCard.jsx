import { DatabaseFillAdd } from "react-bootstrap-icons";
import './ProductCard.css'


export default function ProductCard({id, product, price})
{
    const imageUrl = `images/products/${id}.webp`
    return(
        <div className="card product-card">
            <div id="product-header" className="card-header">{product}</div>
            <div id="product-body" className="card-body">
                <img id="category-image" src={imageUrl} />
            </div>
            <div className="card-footer">Unit Price: ${price}</div>
        </div>




    )




}
import { Trash2Fill, Trash3, Trash3Fill } from "react-bootstrap-icons";
import './ProductCard.css'
import productService from "../../../services/product-service";


export default function ProductCard({id, product, price, onProductDeleted})
{
    const imageUrl = `images/products/${id}.webp`

    async function deleteProduct(event)
    {
        event.stopPropagation();

        await productService.deleteProduct(id); //this is id because even though i wrote productId in service, I am using id as a prop into this component

        onProductDeleted(id); //this function is created on the container/parent level. It will filter the list and rerender an updated list -what we recently deleted
    }


    return(
        <div className="card product-card">
            <div id="product-header" className="card-header">{product}</div>
            <div id="product-body" className="card-body">
                <img id="category-image" src={imageUrl} />
                <li className="list-group-item">Unit Price: ${price}</li>
            </div>
            <div className="card-footer" >
                <Trash3Fill onClick={deleteProduct} color="purple"/>
            </div>
        </div>




    )




}
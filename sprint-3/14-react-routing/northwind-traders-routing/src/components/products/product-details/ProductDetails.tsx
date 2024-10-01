import { useParams } from "react-router-dom"

export default function ProductDetails() {

    const params = useParams();

    return (
        <>
            <h4>Product Details</h4>
            <div className="card bg-secondary mb-3">
                <div className="card-header">Product Id: {params.productId}</div>
                <div className="card-body">
                    <h4 className="card-title">Product Name:</h4>
                    <p className="card-text">Category id:</p>
                    <p className="card-text">Quantity Per Unit:</p>
                    <p className="card-text">Unit Price:</p>
                </div>
            </div>
        </>
    )
}
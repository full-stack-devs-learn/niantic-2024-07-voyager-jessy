import { useParams } from "react-router-dom"

export default function CategoryDetails() {
    const { categoryId } = useParams();
    console.log(categoryId)

    return (
        <>
            {/* <h4> Category Details - Category Id: {categoryId}</h4> */}
            <div className="card bg-secondary mb-3">
                <div className="card-header">Category Details </div>
                <div className="card-body">
                    <h4 className="card-title">Category Name: </h4>
                    <p className="card-text">Category Id: {categoryId}</p>
                    <p className="card-text">Description:</p>

                </div>
            </div>
        </>
    )
}
import { useEffect, useState } from "react";
import { useParams } from "react-router-dom"
import { Category } from "../../../models/categories";
// import axios from "axios";
import categoryService from "../../../services/category-service";

export default function CategoryDetails() {

    const [category, setCategory] = useState<Category>();

   const params = useParams()
   const categoryId = params.categoryId ?? 0;


    async function loadCategory()
    {
        const category = await categoryService.getCategoryById(+categoryId)
        setCategory(category);

    }

    useEffect(() => { loadCategory()}, [])


    return (
        <>
            {/* <h4> Category Details - Category Id: {categoryId}</h4> */}
            <div className="card bg-secondary mb-3">
                <div className="card-header">Category Details </div>
                <div className="card-body">
                    <h4 className="card-title">Category Name: {category?.categoryName}</h4>
                    <p className="card-text">Category Id: {category?.categoryId}</p>
                    <p className="card-text">Description: {category?.description}</p>

                </div>
            </div>
        </>
    )
}
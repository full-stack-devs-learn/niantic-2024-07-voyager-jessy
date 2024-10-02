import { useEffect, useState } from "react"
import { Link, useLocation } from "react-router-dom";
import categoryService from "../../../services/category-service";
import { Category } from "../../../models/categories";
import './CategoriesList.css'

export default function CategoriesList() {

    const [categories, setCategories] = useState<Category[]>([]);

    // const location = useLocation();
    // const params = new URLSearchParams(location.search)

    useEffect(() => { loadCategories() }, [])


    async function loadCategories() {
        const categories = await categoryService.getAllCategories();
        console.log(categories);

        setCategories(categories)
    }


    return (
        <>

            <h1>Categories List</h1>
            <Link className="btn btn-success" to={"/categories/add"}>Add</Link>
            <div className="categories-container">
                {categories.map((category: Category) => (
                    <div className="category-card card mt-3"key={category.categoryId}>
                        <h5 className="category-header mt-3"><Link to={`/categories/${category.categoryId}`}><strong>{category.categoryName}</strong></Link></h5>
                        <div id="category-body" className="card-body">
                            <img id="category-image" src={`images/categories/${category.categoryId}.webp`} />

                        </div>
                        <Link className="btn btn-outline-warning" to={`/categories/${category.categoryId}/edit`}>Edit</Link>
                    </div>
                ))
                }
            </div>

        </>
    )

}
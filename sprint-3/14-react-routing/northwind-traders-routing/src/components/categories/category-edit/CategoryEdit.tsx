import { useEffect, useState, useTransition } from "react";
import { useLocation, useParams } from "react-router-dom";
import categoryService from "../../../services/category-service";
import { Category } from "../../../models/categories";

export default function CategoryEdit() {

    const [ category, setCategory] = useState<Category>();
    const [categoryName, setCategoryName] = useState('');
    const [ description, setDescription] = useState(category?.description);
    const location = useParams();
    const catId = location.categoryId ?? 0;
    // console.log(catId); verified
    
    async function loadCategory()
    {
        const category = await categoryService.getCategoryById(+catId)
        setCategory(category);
        // console.log('loadedcategory',category); verified
        

    }
    

    async function editCategoryHandler(e:any)
    {
        e.preventDefault();
        
        const updatedCategory = {
            categoryName:categoryName,
            description: description
        }
        try{

        await categoryService.editCategory(updatedCategory);

        }
        catch(e)
        {
            console.log(e);
            
        }
    }

   

    useEffect(() => 
    {
        loadCategory();
    }, [])

    useEffect(() => { 
        if(category){
            console.log('first', categoryName);
            

            setCategoryName(category.categoryName);
            setDescription(category.description);
            console.log("cn", categoryName);
            console.log("cn", description);

        
        }
    }, [category]);






    return (
        <>
            <h4>Edit Category</h4>
            <p>Category Id: {catId}</p>
            <form onSubmit={editCategoryHandler}>    
                <div className="row">
                    <label htmlFor="key">Category Name:</label>
                    <input 
                    type="text" 
                    className="form-control" 
                    name="category-name" 
                    id="category-name" 
                    defaultValue={category?.categoryName}
                    onChange={e => setCategoryName(e.target.value)} 
                    ></input>
                </div>
                <div className="row">
                    <label htmlFor="description">Description</label>
                    <input className="form-control mb-3" name="description" id="description" defaultValue={category?.description}
                    onChange={(e) => setDescription(e.target.value)}
                    />
                </div>
                <button className="btn btn-outline-danger mr-3" type="submit">Change</button>
            </form>
        </>
    )
}
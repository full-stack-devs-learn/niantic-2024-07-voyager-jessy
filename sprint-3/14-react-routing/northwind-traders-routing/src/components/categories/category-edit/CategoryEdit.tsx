import { useParams } from "react-router-dom";

export default function CategoryEdit() {

    const { categoryId } = useParams();
    return (
        <>
            <h4>Edit Category</h4>
            <p>Category Id: {categoryId}</p>


        </>
    )
}
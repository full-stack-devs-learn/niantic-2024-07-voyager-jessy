import { useParams } from "react-router-dom"

export default function CategoryDetails()
{
const {categoryId } = useParams();
console.log(categoryId)

    return(
        <h4> Category Details - Category Id: {categoryId}</h4>
    )
}
import axios from "axios"
import { Category } from "../models/categories";
// import { Category } from "../models/categories";

class CategoryService
{
   baseUrl = 'http://localhost:8080/categories'

   async getAllCategories(): Promise<Category[]>
   {
    const response = await axios.get(this.baseUrl)
    return response.data
   }

   async getCategoryById(id:number): Promise<Category>
   {
    const response = await axios.get(`${this.baseUrl}/${id}`)
    return response.data
    
   }

   async addCategory(category: Category): Promise<Category>
   {
    const response = await axios.post<Category>(this.baseUrl, category)
    return response.data

   }

   async editCategory(category: Category): Promise<void>
   {
      const url = `${this.baseUrl}/${category.categoryId}`
      await axios.put<void>(url, category)
   }
}

const categoryService = new CategoryService();
export default categoryService;
import axios from "axios";
import { Product } from "../models/products";


class ProductService{

    baseUrl = 'http://localhost:8080/products'
    // baseUrl = `${import.meta.env.VITE_APP_BASE_URL}/products`

    async getAllProducts():Promise<Product[]>
    {
        const response = await axios.get<Product[]>(this.baseUrl, {
            params:{
                per_page: 20
            }
        })
        return response.data;
    }

    async getProductByProductId(id:number): Promise<Product>
    {
        const response = await axios.get(`${this.baseUrl}/${id}`)
        return response.data
    }

    async addProduct(product:Product):Promise<Product>
    {
        const response = await axios.post<Product>(this.baseUrl, product)
        return response.data
    }


}

const productService = new ProductService();
export default productService;
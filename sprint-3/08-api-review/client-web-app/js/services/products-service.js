class ProductsService {

    baseUrl = `${config.baseUrl}/products`;

    async getProductsByCategory(catId)
    {
        const response = await axios.get(this.baseUrl)
        return response.data;

        // .then(response => { return response.data;});

    }

}
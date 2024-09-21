class ProductsService {

    baseUrl = `${config.baseUrl}/products`;

    getProductsByCategory(categoryId)
    {
    return axios.get(this.baseUrl)
        .then(response => {
            return response.data;
    });

    }

}
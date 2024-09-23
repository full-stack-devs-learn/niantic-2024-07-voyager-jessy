class ProductsService {

    baseUrl = `${config.baseUrl}/products`;

    getProductsByCategory(catId)
    {
    return axios.get(this.baseUrl)
        .then(response => { return response.data;});

    }

}
class PeopleService
{
    baseUrl = `${config.baseUrl}/people`


    async getAllPeopleByPage(pageNumber)
    {
        const url = `${this.baseUrl}?page=${pageNumber}&limit=20`

        // return axios.get(url).then(response => response.data);
        const response = await axios.get(url);
        return response.data;

    }

    async getDetailsByPeopleUid(uid)
    {

        const url = `${this.baseUrl}/${uid}`

        // return axios.get(url)
        // .then(response => response.data);

        const response = await axios.get(url);
        return response.data.result.properties;
    }
}
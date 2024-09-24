class PeopleService
{
    baseUrl = `${config.baseUrl}/people`


    getAllPeopleByPage(pageNumber)
    {
        const url = `${this.baseUrl}?page=${pageNumber}&limit=20`

        return axios.get(url).then(response => response.data);

    }
}
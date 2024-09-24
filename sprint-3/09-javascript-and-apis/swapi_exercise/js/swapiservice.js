class PeopleService
{
    baseUrl = `${config.baseUrl}/people`


    getAllPeopleByPage(pageNumber)
    {
        const url = `${this.baseUrl}?page=${pageNumber}&limit=20`

        return axios.get(url).then(response => response.data);

    }

    getDetailsByPeopleUid(uid)
    {

        const url = `${this.baseUrl}/${uid}`

        return axios.get(url)
        .then(response => response.data);
    }
}
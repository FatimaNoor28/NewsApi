import axios from 'axios'


const NEWS_API_BASE_URL = 'http://localhost:8080/api/news/nyTimes';
// const ACCOUNT_GET_BY_NAME_URL = '/api/v1/account/getAccount';

class NewsService {

    getNews() {
        return axios.get(`${NEWS_API_BASE_URL}/headlines`);
    }
    async getNewsType(category, page){
        return await axios.get(`${NEWS_API_BASE_URL}/${category}/${page}`);
    }

}

export default new NewsService();

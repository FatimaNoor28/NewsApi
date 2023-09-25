import axios from 'axios'


const NY_TIMES_NEWS_API_BASE_URL = 'http://localhost:8080/api/news/nyTimes';
const NATION_NEWS_API_URL = 'http://localhost:8080/api/news/nation';
// const ACCOUNT_GET_BY_NAME_URL = '/api/v1/account/getAccount';

class NewsService {

    getNews() {
        return axios.get(`${NY_TIMES_NEWS_API_BASE_URL}/headlines`);
    }
    async getNewsType(category){
        return await axios.get(`${NY_TIMES_NEWS_API_BASE_URL}/${category}`);
    }
    getNationNews(){
        return axios.get(`${NATION_NEWS_API_URL}/headlines`);
    }
    async getNationNewsType(category){
        return await axios.get(`${NATION_NEWS_API_URL}/${category}`);
    }
}

export default new NewsService();

import axios from 'axios'


const NEWS_API_BASE_URL = 'http://localhost:8080/api/news';
// const ACCOUNT_GET_BY_NAME_URL = '/api/v1/account/getAccount';

class NewsService {

    getNews() {
        return axios.get(`${NEWS_API_BASE_URL}/headlines`);
    }
    getNewsType(category){
        return axios.get(`${NEWS_API_BASE_URL}/${category}`)
    }

}

export default new NewsService();

// getAccountByNameAndPassword(User){
//     console.log(User.userName, User.password, "has been passed to get Account by Name and Password method i.e. service")
//     return axios.get(`${ACCOUNT_GET_BY_NAME_URL}`, {
//         params: {
//             username: User.userName, // Change this to the appropriate property name for username
//             password: User.password, // Change this to the appropriate property name for password
//           },
//       });
// }
// addAccount(account){
//     return axios.post(ACCOUNT_API_BASE_URL, account);
// }
// updateAccount(account){
//     return axios.put(ACCOUNT_API_BASE_URL, account);
// }
// deleteAccount(id){
//     // const accountId = Number(id);
//     return axios.delete(`${ACCOUNT_API_BASE_URL}/${id}`);
// }
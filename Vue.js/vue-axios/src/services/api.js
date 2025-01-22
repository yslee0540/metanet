import axios from "axios";

const apiClient = axios.create({
    baseURL: 'https://jsonplaceholder.typicode.com/',
    headers: {
        'Content-Type': 'application/json'
    }
});

export const fetchItems = () => {
    return apiClient.get('/posts');
};
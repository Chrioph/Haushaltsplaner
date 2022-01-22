import axios from 'axios';

const TASK_REST_API_URL = 'http://localhost:8080/api/tasks';


export function getTasks() {
    return axios.get(TASK_REST_API_URL);
}
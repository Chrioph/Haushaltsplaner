import {HOUSEHOLDS} from "../enum/HOUSEHOLDS";

const BALANCE_REST_API_URL = 'http://localhost:8080/api/balance';



let balance = 10.5;


export function getBalance(household: string) {
    if (household === HOUSEHOLDS.GJ) {
        return 0 - balance
    } else if (household === HOUSEHOLDS.JC) {
        return balance
    }
    return
    // return axios.get(BALANCE_REST_API_URL);
}

export function addToBalance(amount: number, household: string) {
    if (household === HOUSEHOLDS.GJ) {
        balance += amount
    } else if (household === HOUSEHOLDS.JC) {
        balance -= amount
    }
    //return axios.post(BALANCE_REST_API_URL, )
}
import axios from 'axios'

// skapar en instans där vi sätter basurlen för att slippa skriva med den för varje gång vi skapar en fetch composable
export const instance = axios.create({
  baseURL: 'http://localhost:8080/digg/',
})

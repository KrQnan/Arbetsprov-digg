/*
  Vi skapar ett par interfaces för att kunna typa våra api anrop med vad som förväntas komma in
*/
export interface User {
  id: number
  name: string
  address: string
  email: string
  telephone: string
}
export interface UserCreate {
  name: string
  address: string
  email: string
  telephone: string
}
export interface UserUpdate {
  name: string
  address: string
  email: string
  telephone: string
}

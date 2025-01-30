import { instance } from '@/services/API'

//En enkel composable som skapar oss en axios instans för att hämta avändare
const getData = <T>(url: string) => {
  return instance.get<T>(url)
}
//En enkel coposable som skapar oss en axios instans för att skapa användare
const postData = <T>(url: string, data: object) => {
  return instance.post<T>(url, data)
}
//En enkel coposable som skapar oss en axios instans för att uppdatera användare
const putData = <T>(url: string, data: object) => {
  return instance.put<T>(url, data)
}
//En enkel coposable som skapar oss en axios instans för att ta bort användare
const deleteData = <T>(url: string) => {
  return instance.delete<T>(url)
}

//Avgränsar composablen till att använda apiservice innan för lättare läsbarhet
export const APIService = {
  putData,
  deleteData,
  postData,
  getData,
}

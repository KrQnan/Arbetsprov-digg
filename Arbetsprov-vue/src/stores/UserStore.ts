import { APIService } from '@/composables/DataServiceComposable'
import type { User } from '@/models/User'
import type { AxiosError } from 'axios'
import { defineStore } from 'pinia'
import { ref } from 'vue'

export const useUserStore = defineStore('userStore', () => {
  //Våran state med users
  const users = ref<User[]>()

  //En funktion som hämtar alla våra users från backend och lägger till i en Pinia store för global access över projektet
  async function getUsers() {
    try {
      const { data, status } = await APIService.getData<User[]>('user')
      if (status == 200) {
        users.value = data
        return {
          sucess: true,
          content: null,
          status: 200,
        }
      }
    } catch (error) {
      const _error = error as AxiosError<string>
      return {
        sucess: false,
        status: _error.response?.status,
        content: null,
      }
    }
    return {
      sucess: false,
      content: null,
      status: 400,
    }
  }
  //kalla på funktionen inuti storen för att hämta users när den instansieras
  getUsers()

  return { getUsers, users }
})

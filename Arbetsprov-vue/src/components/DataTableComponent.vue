<!--
  Detta är en enkel men stilig tabell komponent där vi kan göra alla operationer mot databasen så som skapa, ta bort, uppdatera och visa användare.
  Komponenten låter även oss att bläddra mellan användare där vi har 10 användare per sida och ett par pilar för navigering mellan dom.

-->
<template>
  <div class="container flex flex-col gap-2">
    <table class="border-2 w-full">
      <thead class="bg-green-400 text-black">
        <tr>
          <th>#</th>
          <th>Name</th>
          <th>Adress</th>
          <th>Email</th>
          <th>Telephone</th>
          <th>Actions</th>
        </tr>
      </thead>
      <tbody class="text-white bg-neutral-700">
        <tr v-for="user in paginatedUsers" :key="user.id">
          <td>{{ user.id }}</td>
          <td>{{ user.name }}</td>
          <td>{{ user.email }}</td>
          <td>{{ user.address }}</td>
          <td>{{ user.telephone }}</td>
          <td>
            <div class="flex justify-center gap-4 w-full">
              <button
                @click="((updateUserModal = true), (currentUser = user.id))"
                class="px-6 py-2 bg-yellow-400 text-white"
              >
                <i class="fi fi-rr-pencil"></i>
              </button>
              <button
                @click="((deleteUserModal = true), deleteUser(user.id))"
                class="px-6 py-2 bg-red-400 text-white"
              >
                <i class="fi fi-rs-trash"></i>
              </button>
            </div>
          </td>
        </tr>
      </tbody>
    </table>
    <div class="flex flex-row justify-between">
      <div class="pagnation-buttons">
        <button
          :style="page > 1 ? 'visible' : 'visibility:hidden'"
          @click="page--"
          class="bg-amber-50 text-black px-4"
        >
          <i class="fi fi-rs-angle-small-left"></i>
        </button>
        <button
          :style="page < totaluserPages! ? 'visible' : 'visibility:hidden'"
          @click="page++"
          class="bg-amber-50 text-black px-4"
        >
          <i class="fi fi-rs-angle-small-right"></i>
        </button>
      </div>
      <button @click="createUserModal = true" class="px-6 py-2 bg-green-800 text-white w-32">
        <i class="fi fi-rs-user-add"></i>
      </button>
    </div>
  </div>
  <Teleport to="body">
    <DataModalCopmonent
      :show="createUserModal"
      @close="createUserModal = false"
      v-model:data="userObject"
      @post="(createUser(userObject), (createUserModal = false))"
    >
      <span class="px-4 py-2 bg-green-700 text-white m-4">Create</span>
    </DataModalCopmonent>
    <DataModalCopmonent
      :show="updateUserModal"
      @close="updateUserModal = false"
      v-model:data="userObject"
      @post="(updateUser(userObject), (updateUserModal = false))"
    >
      <span class="px-4 py-2 bg-yellow-400 m-4">Update</span>
    </DataModalCopmonent>
    <DeleteModalComponent :show="deleteUserModal" @close="deleteUserModal = false" />
  </Teleport>
</template>

<script setup lang="ts">
import { computed, ref } from 'vue'
import { useUserStore } from '../stores/UserStore'
import DataModalCopmonent from './DataModalCopmonent.vue'
import DeleteModalComponent from './DeleteModalComponent.vue'
import { APIService } from '@/composables/DataServiceComposable'
import type { UserCreate, UserUpdate } from '@/models/User'
const store = useUserStore()

const page = ref<number>(1)
const userPerPage = 10
const currentUser = ref<number>()
const userObject = ref<UserCreate>({
  name: '',
  email: '',
  address: '',
  telephone: '',
})
const updateUserModal = ref<boolean>(false)
const deleteUserModal = ref<boolean>(false)
const createUserModal = ref<boolean>(false)

const totaluserPages = computed(() => store.users?.length && store.users.length / userPerPage)

const paginatedUsers = computed(() =>
  store.users?.slice((page.value - 1) * userPerPage, page.value * userPerPage),
)
function resetTempUser() {
  userObject.value = {
    name: '',
    email: '',
    address: '',
    telephone: '',
  }
}
function createUser(user: UserCreate) {
  APIService.postData<UserCreate>('create', {
    name: user.name,
    address: user.address,
    telephone: user.telephone,
    email: user.email,
  })
    .then(function (response) {
      store.getUsers()
      resetTempUser()
      console.log(response)
    })
    .catch(function (error) {
      console.log(error)
    })
}

function updateUser(user: UserUpdate) {
  APIService.putData<UserUpdate>(`update/${currentUser.value}`, {
    name: user.name,
    address: user.address,
    telephone: user.telephone,
    email: user.email,
  })
    .then(function (response) {
      store.getUsers()
      resetTempUser()
      console.log(response)
    })
    .catch(function (error) {
      console.log(error)
    })
}
function deleteUser(id: number) {
  APIService.deleteData<UserUpdate>(`delete/${id}`)
    .then(function (response) {
      store.getUsers()
      console.log(response)
    })
    .catch(function (error) {
      console.log(error)
    })
}
</script>

<style scoped>
span {
  font-weight: 700;
}
th {
  transition: 0.5s;
  text-align: left;
}
th:last-child {
  text-align: center;
}
th:hover {
  color: black;
  background-color: white;
}
td,
th {
  padding: 8px;
}
.pagnation-buttons {
  width: 7rem;
  display: flex;
  justify-content: start;
  gap: 0.5rem;
}
.action-buttons {
  display: flex;
  gap: 0.5rem;
}
</style>

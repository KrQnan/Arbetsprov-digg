<!--
  En modal som har smart skapats för att kunna ta emot små förändringar så den kan var anpassningsbar till att vara en createUserModal och en updateUserModal
-->
<template>
  <Transition name="modal">
    <div v-if="props.show" class="modal-mask text-black">
      <div class="modal-container">
        <form>
          <div>
            <label for="name">Name</label>
            <input type="text" name="name" v-model="model.name" />
          </div>
          <div>
            <label for="email">Email</label>
            <input type="email" name="email" v-model="model.email" />
          </div>
          <div>
            <label for="address">Address</label>
            <input type="text" name="address" v-model="model.address" />
          </div>
          <div>
            <label for="telephone">Telephone</label>
            <input type="text" name="telephone" v-model="model.telephone" />
          </div>
        </form>
        <div class="flex gap-4">
          <button @click="emits('post')">
            <slot />
          </button>
          <button @click="emits('close')">
            <span class="px-4 py-2 bg-red-400 text-white">Close</span>
          </button>
        </div>
      </div>
    </div>
  </Transition>
</template>

<script setup lang="ts">
import type { UserCreate, UserUpdate } from '@/models/User'
const props = defineProps({
  show: Boolean,
})
const emits = defineEmits(['close', 'post'])
const model = defineModel<UserCreate | UserUpdate>('data', {
  default: { name: '', address: '', email: '', telephone: '' },
})
</script>

<style scoped>
.modal-container {
  width: 500px;
  height: 500px;
  margin: auto;
  padding: 20px 30px;
  background-color: var(--color-neutral-100);
  border-radius: 2px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.33);
  transition: all 0.3s ease;
}
span {
  font-weight: 700;
}
form {
  display: flex;
  flex-direction: column;
  gap: 1rem;
  margin-bottom: 2rem;
}
input {
  width: 100%;
  padding: 0.5rem 1rem;
  border: 1px solid rgb(1, 1, 1);
  border-radius: 2.5px;
  box-sizing: border-box;
}
label {
  font-weight: bold;
  color: black;
}
</style>

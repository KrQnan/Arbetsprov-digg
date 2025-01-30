<template>
  <Transition name="modal">
    <div v-if="props.show" class="modal-mask">
      <div class="modal-container">
        <span class="text-black">Användare borttagen!</span>
        <button @click="$emit('close')">
          <span class="px-4 py-2 bg-red-400 text-white">Close</span>
        </button>
      </div>
    </div>
  </Transition>
</template>

<script setup lang="ts">
const props = defineProps({
  show: Boolean,
})
</script>

<style scoped>
.modal-container {
  width: 500px;
  height: 200px;
  display: flex;
  flex-direction: column;
  justify-content: space-around;
  padding: 20px 30px;
  background-color: var(--color-neutral-100);
  border-radius: 2px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.33);
  transition: all 0.3s ease;
}

span {
  font-weight: 700;
  text-align: center;
}
button {
  display: flex;
  justify-content: end;
  align-items: end;
}
</style>

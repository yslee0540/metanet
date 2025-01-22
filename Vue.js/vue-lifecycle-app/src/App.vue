<template>
  <div id="app">
    <h1>Vue 라이프사이클 데모</h1>
    <button @click="toggleChild">자식 컴포넌트 {{ showChild ? '숨기기' : '보이기' }}</button>
    <hr>
    <ChildComponent v-if="showChild" :count="count" />
    <button @click="incrementCount">카운트 증가</button>
  </div>
</template>

<script>
import { ref } from 'vue'
import ChildComponent from './components/ChildComponent.vue';
export default {
  name: 'App',
  components: {
    ChildComponent,
  },
  setup() {
    const showChild = ref(true);
    const count = ref(0);
    const toggleChild = () => {
      showChild.value = !showChild.value;
    };
    const incrementCount = () => {
      count.value++;
    };
    return { 
      showChild, count, toggleChild, incrementCount 
    };
  },
};
</script>

<style>
#app {
  font-family: Arial, Helvetica, sans-serif;
  text-align: center;
  margin-top: 20px;
}
</style>

<template>
  <div id="app">
    <h1>Vue 전역 및 지역 컴포넌트</h1>
    <GlobalComponent message="Hello from App.vue!"/>
    <hr/>
    <LocalComponent @custom-event="handleCustomEvent" />
    <p>자식 컴포넌트로부터 받은 메세지: {{ childMessage }}</p>
  </div>
</template>

<script>
import LocalComponent from './components/LocalComponent.vue';
export default {
  name: 'App',
  components: {
    LocalComponent,
  },
  data() {
    return {
      childMessage: '',
    };
  },
  methods: {
    handleCustomEvent(message) {
      this.childMessage = message;
    },
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

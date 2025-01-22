<template>
  <div id="app">
    <BindingEventExample />
  </div>
</template>

<script>
import BindingEventExample from './components/BindingEventExample.vue';

export default {
  name: "App",
  components: {
    BindingEventExample,
  },
};
</script>

<style>
#app {
  text-align: center;
  margin-top: 40px;
}
</style>

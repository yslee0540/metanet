<template>
  <div id="app">
    <h1>Vuex Events Example</h1>
    <p>Count: {{ count }}</p>
    <button @click="increment">Increment</button>
    <button @click="fetchItems">Fetch Items</button>
    <p>Total Items: {{ itemCount }}</p>
    <ul>
      <li v-for="item in items" :key="item.id">{{ item.title }}</li>
    </ul>
  </div>
</template>

<script>
import { mapState, mapMutations, mapActions, mapGetters } from 'vuex';
export default {
  computed: {
    ...mapState(['count', 'items']),
    ...mapGetters(['itemCount']),
  },
  methods: {
    ...mapMutations(['increment']),
    ...mapActions(['fetchItems']),
  }
};
</script>

<style>
</style>

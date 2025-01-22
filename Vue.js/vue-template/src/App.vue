<template>
  <div id="app">
    <h1>Vue Template Example</h1>
    <UserCard :user="user1" />
    <UserCard :user="user2" />
  </div>
</template>

<script>
import UserCard from './components/UserCard.vue';
export default {
  name: "App",
  components: {
    UserCard
  },
  data() {
    return {
      user1: {
        name: "Alice",
        email: "alice@example.com",
        age: 30,
        avatar: "https://via.placeholder.com/100",
        active: true
      },
      user2: {
        name: "Bob",
        email: "bob@example.com",
        age: 25,
        avatar: "https://via.placeholder.com/100",
        active: false
      },
    }
  }
};
</script>

<style scoped>
#app {
  color: #2c3e50;
  margin-top: 40px;
}
</style>

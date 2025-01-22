<template>
    <div class="user-card">
        <h2>{{ user.name }}</h2>
        <p>Email: {{ user.email }}</p>
        <p>Age: {{ user.age }}</p>

        <img :src="user.avatar" alt="User Avatar"/>
        <button @click="showMessage">Say Hello</button>

        <p v-if="user.active">User is active</p>
        <p v-else>User is inactive</p>
    </div>
</template>

<script>
export default {
    name: "UserCard",
    props: {
        user: {
            type: Object,
            required: true
        },
    },
    methods: {
        showMessage() {
            alert(`Hello, ${this.user.name}!`);
        }
    }
};
</script>

<style>
.user-card {
    border: 1px solid #ccc;
    margin: 16px;
    border-radius: 8px;
}
</style>
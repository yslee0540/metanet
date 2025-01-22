<template>
    <div class="home">
        <h1>Welcome to the Home Page</h1>
        <p>This is the main page of the application.</p>
        <router-link to="/about">Go to About Page</router-link>
    </div>
</template>

<script>
export default {
    name: 'HomeView',
};
</script>

<style>
.home {
    text-align: center;
    margin-top: 50px;
}
</style>
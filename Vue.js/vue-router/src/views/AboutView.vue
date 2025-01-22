<template>
    <div class="about">
        <h1>About Us</h1>
        <p>This page provides information about our application.</p>
        <router-link to="/">Back to Home</router-link>
    </div>
</template>

<script>
export default {
    name: 'AboutView',
};
</script>

<style>
.about {
    text-align: center;
    margin-top: 50px;
}
</style>
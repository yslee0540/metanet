<template>
  <div id="app">
    <nav>
      <ul>
        <li>
          <router-link to="/">Home</router-link>
        </li>
        <li>
          <router-link to="/about">About</router-link>
        </li>
      </ul>
    </nav>
    <main>
      <router-view />
    </main>
  </div>
</template>

<script>
export default {
  name: 'App'
};
</script>

<style scoped>
#app {
  text-align: center;
}

nav ul {
  list-style-type: none;
  padding: 0;
  display: flex;
  justify-content: center;
  gap: 20px;
}

nav ul li {
  display: inline;
}

nav ul li a {
  text-decoration: none;
  color: #42b983;
}

nav ul li a.router-link-active {
  font-weight: bold;
  color: #35495e;
}
</style>

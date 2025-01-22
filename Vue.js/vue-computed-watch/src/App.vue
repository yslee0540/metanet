<template>
  <div id="app">
    <h1>Computed and Watch Example</h1>

    <!-- Computed -->
     <section>
      <h2>Computed Example</h2>
      <input v-model="message" placeholder="Type something" />
      <p>Original Message: {{ message }}</p>
      <p>Reversed Message: {{ reversedMessage }}</p>
     </section>

    <!-- Wacth -->
     <section>
      <h2>Wacth Example</h2>
      <p>Counter: {{ count }}</p>
      <button @click="count++">Increase Counter</button>
      <p v-if="logMessage">{{ logMessage }}</p>
     </section>
  </div>
</template>

<script>
export default {
  data() {
    return {
      message: '',
      count: 0,
      logMessage: '',
    };
  },
  computed: {
    reversedMessage() {
      return this.message.split('').reverse().join('');
    }
  },
  watch: {
    count(newValue, oldValue) {
      this.logMessage = `Count changed from ${oldValue} to ${newValue}`;
      setTimeout(() => {
        this.logMessage = '';
      }, 2000);
    }
  }
};
</script>

<style scoped>
</style>

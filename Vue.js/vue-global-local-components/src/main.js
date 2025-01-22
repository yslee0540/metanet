import { createApp } from 'vue'
import App from './App.vue'
import GlobalComponent from './components/GlobalComponent.vue';

//Vue 앱 생성
const app = createApp(App);

//전역 컴포넌트
app.component('GlobalComponent', GlobalComponent);

app.mount('#app')

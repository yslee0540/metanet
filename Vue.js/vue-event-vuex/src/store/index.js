import { createStore } from 'vuex';

const store = createStore({
    state: {
        count: 0,
        items: [],
    },
    mutations: {
        increment(state) {
            state.count++;
        },
        setItems(state, items) {
            state.items = items;
        },
    },
    actions: {
        async fetchItems({ commit }) {
            const data = await fetch('https://jsonplaceholder.typicode.com/posts').then(res => res.json());
            commit('setItems', data);
        },
    },
    getters: {
        itemCount: (state) => state.items.length,
    },
});
export default store;
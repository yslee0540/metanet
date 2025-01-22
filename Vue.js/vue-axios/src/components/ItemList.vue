<template>
    <div class="item-list">
        <h1>Item List</h1>
        <ul>
            <li v-for="item in items" :key="item.id">
                <h3>{{ item.title }}</h3>
                <p>{{ item.body }}</p>
            </li>
        </ul>
        <p v-if="error" class="error">{{ error }}</p>
    </div>
</template>

<script>
import { fetchItems } from '../services/api';
export default {
    name: 'ItemList',
    data() {
        return {
            items: [],
            error: null
        };
    },
    mounted() {
        this.loadItems();
    },
    methods: {
        async loadItems() {
            try {
                const response = await fetchItems();
                this.items = response.data;
            } catch (err) {
                this.error = 'Failed to load items. Please try again.';
                console.error(err);                
            }
        }
    }
};
</script>

<style>
.items-list {
    margin: 20px;
}
</style>
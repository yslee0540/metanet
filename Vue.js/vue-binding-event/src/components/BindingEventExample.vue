<template>
    <div class="example-container">
        <h1>Vue 데이터 바인딩 & 이벤트 처리</h1>
        <div>
            <h2>데이터 바인딩 예제</h2>
            <p>이름: {{ name }}</p>
            <input v-model="name" placeholder="이름을 입력하세요"/>
        </div>
        <hr>
        <div>
            <h2>이벤트 처리 예제</h2>
            <button @click="incrementCounter">클릭 횟수 증가</button>
            <p>클릭 횟수: {{ counter }}</p>
        </div>
        <hr>
        <div>
            <h2>데이터 바인딩과 이벤트 결합</h2>
            <input v-model="newItem" @keyup.enter="addItem" placeholder="아이템 추가 후 Enter 키" />
            <ul>
                <li v-for="(item, index) in items" :key="index">
                    {{ item }}
                    <button @click="removeItem(index)">삭제</button>
                </li>
            </ul>
        </div>
    </div>
</template>

<script>
export default {
    name: "BindingEventExample",
    data() {
        return {
            name: "홍길동",
            counter: 0,
            newItem: "",
            items: [],
        };
    },
    methods: {
        incrementCounter() {
            this.counter++;
        },
        addItem() {
            if (this.newItem) {
                this.items.push(this.newItem);
                this.newItem = "";
            }
        },
        removeItem(index) {
            this.items.splice(index, 1);
        },
    },
};
</script>

<style>
.example-container {
    padding: 20px;
    font-family: Arial, Helvetica, sans-serif;
}

h2 {
    margin-top: 20px;
}

input {
    margin-bottom: 10px;
    padding: 8px;
    border: 1px solid #ccc;
    border-radius: 4px;
}

button {
    margin-left: 10px;
    padding: 5px 10px;
    border: none;
    background-color: #007bff;
    color: white;
    border-radius: 4px;
    cursor: pointer;
}

button:hover {
    background-color: #0056b3;
}
</style>
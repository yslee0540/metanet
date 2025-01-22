<template>
    <div>
        <p>이것은 지역 컴포넌트입니다</p>
        <button @click="sendToParent">부모에게 메세지 보내기</button>
    </div>
</template>

<script>
export default {
    name: 'LocalComponent',
    emits: ['custom-event'],
    setup(_, { emit }) {
        const sendToParent = () => {
            emit('custom-event', '자식에서 보낸 메세지입니다');
        };
        return { sendToParent };
    },
};
</script>
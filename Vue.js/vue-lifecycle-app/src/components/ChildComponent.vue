<template>
    <div>
        <h2>자식 컴포넌트</h2>
        <p>부모에서 전달된 카운트: {{ count }}</p>
    </div>
</template>
<script>
import { onMounted, onUpdated, watch, toRefs, onUnmounted } from 'vue';
export default {
    name: 'ChildComponent',
    props: {
        count: {
            type: Number,
            required: true,
        },
    },
    setup(props) {
        const { count } = toRefs(props);
        onMounted(() => {
            console.log('ChildComponent가 마운트되었습니다.')
        });
        onUpdated(() => {
            console.log('ChildComponent가 업데이트되었습니다.')
        });
        onUnmounted(() => {
            console.log('ChildComponent가 언마운트되었습니다.')
        });
        watch(count, (newVal, oldVal) => {
            console.log(`count 값 변경: ${oldVal} -> ${newVal}`);
        });
        return { count };
    },
};
</script>
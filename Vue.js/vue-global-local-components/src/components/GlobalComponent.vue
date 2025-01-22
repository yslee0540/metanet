<template>
    <div>
        <p>이것은 전역 컴포넌트입니다</p>
        <p>부모로부터 받은 메세지: {{ message }}</p>
    </div>
</template>

<script>
export default {
    name: 'GlobalComponent',
    props: {
        message: {
            type: String,
            required: true,
        },
    },
};
</script>
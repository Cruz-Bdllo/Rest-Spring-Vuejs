<template>
    <div class="container">
        <h1 class="text-center mt-4">Profile {{client.name}}</h1>
        <router-link to="/" class="breadcrumb mt-5">Back to clients list</router-link>

        <p>Name: {{client.name}}</p>
        <p>Email: {{client.email}}</p>
        <p>Age: {{client.age}}</p>
        <p>Genre: {{client.genre==1?'Male':'Famale'}}</p>
    </div>
</template>

<script>
    import {mapState, mapActions} from 'vuex'

    export default {
        name: 'Profile',
        data(){
            return {
            }
        },
        computed: {
            ...mapState(['client'])
        },
        methods:{
            ...mapActions(['findClientById'])
        },
        mounted(){
            this.findClientById(this.$route.params.id);
        }
    }
</script>
<template>
    <div class="table-clients my-5">
        <!-- New client -->
        <router-link class="btn btn-success btn-block mb-3" to="/new-client">Add new client</router-link>

        <table class="table table-bordered text-center">
            <!-- Head table -->
            <thead class="thead-dark">
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Age</th>
                    <th>Genre</th>
                    <th>Profile</th>
                    <th>Update</th>
                    <th>Delete</th>
                </tr>
            </thead>
            <!-- Body table -->
            <tbody>
                <tr v-for="client in clientes" :key="client.idClient">
                    <td>{{client.idClient}}</td>
                    <td>{{client.name}}</td>
                    <td>{{client.email}}</td>
                    <td>{{client.age}}</td>
                    <td>{{(client.genre == 1 ? 'Male':'Famale')}}</td>
                    <td>
                        <router-link class="btn btn-info" :to="{ name:'Profile', params:{id:client.idClient} }">view</router-link>
                    </td>
                    <td>
                        <router-link class="btn btn-warning" :to="{name:'UpdateClient', params:{id:client.idClient}}">Update</router-link>
                    </td>
                    <td><button class="btn btn-danger" v-on:click="deleteClient(client.idClient)">delete</button></td>
                </tr>
            </tbody>
        </table>
    </div>
</template>

<script>
    import {mapState, mapActions} from 'vuex';
    import {Client} from '../entities/Client';

    export default {
        name: 'TableClients',
        data(){
            return {
                //clients:[]
            }
        }, // end data
        computed:{
            ...mapState({
                clientes: 'clients'
                })
        },
        methods:{
            ...mapActions(['getAllClientsDB', 'deleteClient']),
            delete(id){
                this.deleteClient(id)
            }
        },
        created(){
            this.getAllClientsDB()
        } // end mounted
    }
</script>
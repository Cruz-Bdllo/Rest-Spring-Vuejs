<template>
    <div class="container form-client">
        <h1 class="text-center mt-4">Add new client</h1>

        <router-link to="/" class="breadcrumb mt-5">Back to clients list</router-link>
        
        <!-- Form -->
        <form v-on:submit.prevent="save" >
            <input type="hidden" v-model="client.idClient">
            
            <!-- Name -->
            <!-- {{client.name}} -->
            <div class="form-group">
                <label for="name-user">FullName client</label>
                <input type="text" v-model="client.name" class="form-control" id="name-user" aria-describedby="emailHelp">
            </div>

            <!-- Email -->
            <!-- {{client.email}} -->
            <div class="form-group">
                <label for="email">Email</label>
                <input type="email" class="form-control" id="email" v-model="client.email">
            </div>

            <!-- Age -->
            <!-- {{client.age}} -->
            <div class="form-group">
                <label for="age">Age</label>
                <input type="text" class="form-control" id="age" v-model="client.age">
            </div>

            <!-- Genre -->
            <!-- {{client.genre}} -->
            <div class="form-group">
                <label for="genre">Select your genre</label>
                <select class="form-control" id="genre" v-model="client.genre">
                    <option value="0">Famale</option>
                    <option value="1">Male</option>
                </select>
            </div>
            <button type="submit" class="btn btn-primary" >Save client</button>
        </form>
    </div>
</template>

<script>
import { mapState, mapActions } from 'vuex';
    import Client from '../entities/Client'

    export default {
        name: 'FormClient',
        data(){
            return {
            }
        }, // end data
        computed:{
            ...mapState(['client', 'getClient'])
        },
        methods:{ // here will execute an actions that connect to backend
            ...mapActions(['findClientById', 'saveClient', 'updateClient']),
            save(){
                const clientForm = new Client();
                clientForm.idClient = this.client.idClient;
                clientForm.name=this.client.name;
                clientForm.email=this.client.email;
                clientForm.age=this.client.age;
                clientForm.genre=this.client.genre;
                
                if(clientForm.idClient == undefined){
                    this.saveClient(clientForm);
                }else{
                    this.updateClient(clientForm);
                }
                //console.log(clientForm);
            }
        }, // end methods
        created(){
            this.findClientById(this.$route.params.id);
        }
    } // end export
</script>
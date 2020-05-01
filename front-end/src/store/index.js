import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'
import VueAxios from 'vue-axios'
import Client from '../entities/Client'
import router from '../router/index'

Vue.use(Vuex, VueAxios, axios)

export default new Vuex.Store({
    state: {
        clients: [],
        client: Client
    },
    mutations: {
        fillClients(state, response){
            state.clients = response;
        },
        setClientMutation(state, response){
            
            state.client = response;
        },
        updateListClients(state, id){
            state.clients = state.clients.filter(
                c => { 
                    return c.idClient != id
                }
            );
        }
    },
    actions: { // connect with database
        getAllClientsDB(commit){
            axios.get("http://127.0.0.1:8585/api/all")
            .then((response)=>{
                
                //console.log(response.data);
                this.commit('fillClients', response.data);

            })
        },
        findClientById(commit, idClient){
            idClient = (idClient == undefined) ? 0 : idClient;
            const clientAxios = new Client();
            axios.get("http://127.0.0.1:8585/api/find/"+idClient)
                .then((response)=>{
                    
                    clientAxios.idClient = response.data.idClient;
                    clientAxios.name     = response.data.name;
                    clientAxios.email    = response.data.email;
                    clientAxios.age      = response.data.age;
                    clientAxios.genre    = response.data.genre;
                    
                    this.commit('setClientMutation', clientAxios);
                })// add exception
            
            
        },
        saveClient(commit, payload){
            //console.log("The client will be saved");
            
            axios.post("http://127.0.0.1:8585/api/save/", payload)
            .then((response) => {
                console.log(response);
                router.push({name: 'Home'});
            })
        },
        updateClient(commit, payload){
            //console.log("The client will be updated");
            axios.put("http://127.0.0.1:8585/api/update/"+ payload.idClient, payload)
            .then((response) => {
                console.log(response);
                router.push({name: 'Home'});
            })
        },
        deleteClient(commit, payload){
            //console.log("will be deleted id " + payload);
            axios.delete("http://127.0.0.1:8585/api/delete/"+ payload)
            .then((response) => {
                console.log(response);
                this.commit('updateListClients', payload)
                // router.push({name:'Home'});
                //this.getAllClientsDB()
            })
        }
    },
    getters: {
        getClient(){
            return this.state.client;
        }
    }
})

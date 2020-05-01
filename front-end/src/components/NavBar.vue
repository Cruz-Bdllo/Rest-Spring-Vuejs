<template>
    <div class="menu">
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" href="#">API Rest</a>
            <button
                class="navbar-toggler"
                type="button"
                data-toggle="collapse"
                data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent"
                aria-expanded="false"
                aria-label="Toggle navigation"
            >
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item" v-for="route in routes" :key="route.id">
                        <router-link class="nav-link" :to="{name:route.name}">{{route.name}}</router-link>
                        
                    </li>
                
                </ul>
            </div>
        </nav>
    </div>
</template>

<script>
    export default {
        name: 'NavBar',
        data(){
            return{
                routes:[
                    {id:0, name:'Home', path: '/'},
                    {id:1, name:'About', path: '/about'},
                    {id:2, name:'Service', path: '/service'}
                ]
            }
        } // end data
    } // end export default
</script>
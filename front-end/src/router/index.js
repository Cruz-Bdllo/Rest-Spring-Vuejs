import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

const routes = [
    {
        path: '/',
        name: "Home",
        component: () => import(/* webpackChunkName: "home" */ '../views/Home')
    },
    {
        path: '/about',
        name: 'About',
        component: () => import(/* webpackChunkName: "about" */ '../views/About')
    },
    {
        path: '/service',
        name: 'Service',
        component: () => import(/* webpackChunkName: "service" */ '../views/Service')
    },
    {
        path: '/new-client',
        name: 'AddClient',
        component: () => import(/* webpackChunkName: "addclient" */ '../views/FormClient')
    },
    {
        path: '/update-client/:id',
        name: 'UpdateClient',
        component: () => import(/* webpackChunkName: "updateclient" */ '../views/FormClient')
    },
    {
        path: '/profile/:id',
        name: 'Profile',
        component: () => import(/* webpackChunkName: "profile" */ '../views/Profile')
    }
]

const router = new VueRouter({
    mode: 'history',
    routes
})

export default router

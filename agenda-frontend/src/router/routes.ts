import Home from '../components/HelloWorld.vue'


const routes = [
    {
        icon: "home",
        path: '/',
        name: 'Home',
        component: Home
    },
    {
        icon: "today",
        path: '/agendamento',
        name: 'Agendamento',
        component: () => import('../pages/Agenda.vue')
    },
    {
        icon: "bussines",
        path: '/servicos',
        name: 'Servicos',
        component: () => import('../pages/Servicos.vue')
    },
    {
        icon: "bussines",
        path: '/cliente',
        name: 'Cliente',
        component: () => import('../pages/Cliente.vue')
    },
    {
        icon: "bussines",
        path: '/atendente',
        name: 'Atendente',
        component: () => import('../pages/Atendente.vue')
    },
    {
        icon: "",
        path: '/login',
        name: 'Login',
        component: () => import('../pages/login.vue')
    },

]
export default routes
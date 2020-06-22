import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    redirect: "login"
  },
  {
    path: '/login',
    name: 'Login',
    component: () => import('../views/Login.vue')
  },
  {
    path: '/console',
    name: 'Console',
    component: () => import('../views/main/index'),
    children:[
      {
        path: '/about',
        name: 'About',
        component: () => import('../views/nav01/About.vue')
      },
      {
        path: '/about1',
        name: 'About1',
        component: () => import('../views/nav01/About1.vue')
      },
    ]
  }
]

const router = new VueRouter({
  routes
})

export default router

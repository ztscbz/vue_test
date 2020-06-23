import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

const originalPush = VueRouter.prototype.push
VueRouter.prototype.push = function push(location) {
  return originalPush.call(this, location).catch(err => err)
}
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
    path: '/display',
    name: 'Display',
    component: () => import('../views/nav01/Display.vue')
  },
  {
    path: '/console',
    name: 'Console',
    component: () => import('../views/main/Index'),
    children:[
      {
        path: '/blog',
        name: 'Blog',
        component: () => import('../views/nav01/Index.vue')
      },

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

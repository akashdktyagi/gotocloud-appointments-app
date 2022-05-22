import { createRouter, createWebHistory } from 'vue-router'
import Home from '@/components/Home.vue'


const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home
    },
    {
      path: '/doctors',
      name: 'doctors',
      component: () => import('@/components/Doctors.vue')
    },
    {
      path: '/doctors/admin',
      name: 'doctorsadmin',
      component: () => import('@/components/DoctorsAdmin.vue')
    },
    {
      path: '/pageIsNotReadyYet',
      name: 'pageIsNotReadyYet',
      component: () => import('@/components/PageIsNotReadyYet.vue')
    }

  ]
})

export default router

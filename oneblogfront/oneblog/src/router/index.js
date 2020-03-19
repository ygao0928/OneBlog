import Vue from 'vue'
import Router from 'vue-router'

const Login = () => import('@/components/Login')
const Home = () => import('@/components/admin/common/Home')
Vue.use(Router)

export default new Router({
  
  routes: [
        {
      path:'/login',
      name:'登录',
      component:Login,
      redirect: '/admin/login'
    },
    {
      path:'/admin/login',
      name:'登录',
      component:Login
    },
    {
      path:'/admin',
      name:'后台',
      component:Home,
      children:[
        {
          path:'/index',
          component:()=>import('@/components/admin/views/artice/index'),
          meta:{title:'新增文章'}
        }
        ,
        {
          path:'/addartice',
          component:()=>import('@/components/admin/views/artice/AddArtice'),
          meta:{title:'新增文章'}
        }
      ]
    },
    {
      path:'/tag',
      component:()=>('@/components/admin/views/tag/index'),
      meta:{title:'标签'}
    },
    {
      path:'/user',
      component:()=>('@/components/admin/views/user/index'),
      meta:{title:'用户'}
    },
  ]
})

// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import './utils/filter_utils.js'
import {postRequest,uploadFileRequest,putRequest,deleteRequest,getRequest} from './utils/api.js'
import axios from 'axios'
import moment from 'moment'
import mavonEditor from 'mavon-editor'  //引入mavon-editor 就是上面所安装的
import 'mavon-editor/dist/css/index.css'

Vue.config.productionTip = false
Vue.prototype.$postRequest=postRequest;
Vue.prototype.$putRequest=putRequest;


Vue.prototype.$axios = axios
Vue.prototype.moment=moment
Vue.use(ElementUI);
Vue.use(mavonEditor)  //让Vue使用mavonEditor
/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})

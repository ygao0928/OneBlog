<template>
  <el-form class="login-container" v-loading="loading" label-width="0px">
    <h3>OneBlog后台登录</h3>
    <el-form-item>
      <el-input v-model="loginForm.username" type="text" placeholder="用户名" />
    </el-form-item>
    <el-form-item>
      <el-input v-model="loginForm.password" type="password" placeholder="密码" />
    </el-form-item>
    <el-form-item style="width: 100%">
      <el-button type="primary" @click.native.prevent="submitClick" style="width: 100%">登录</el-button>
    </el-form-item>
  </el-form>
</template>

<script>
import { postRequest } from "../utils/api";
import { putRequest } from "../utils/api";
import Vue from 'vue'
import VueCookies from 'vue-cookies'
Vue.use(VueCookies)
export default {
  data() {
    return {
      loginForm: {
        username: "高勇",
        password: "123456"
      },
      loading: false
    };
  },
  methods: {
    submitClick: function() {
      var _this = this;
      this.loading = true;
      postRequest("/admin/login", {
        username: this.loginForm.username,
        password: this.loginForm.password
      }).then(
        resp => {
          _this.loading = false;
          if (resp.status == 200) {
            var json = resp.data;
            console.log(json);
            if (json.error == "Success") {
              console.log(json.data[0].id);
              
              _this.$cookies.set('userid',json.data[0].id);
              _this.$router.replace({ path: "/index" });
            } else {
              _this.$alert("登录失败!", "失败!");
            }
          } else {
            _this.$alert("登录失败!", "失败!");
          }
        },
        resp => {
          _this.loading = false;
          _this.$alert("找不到服务器⊙﹏⊙∥!", "失败!");
        }
      );
    }
  }
};
</script>

<style>
.login-container {
  border-radius: 15px;
  background-clip: padding-box;
  margin: 180px auto;
  width: 350px;
  padding: 35px 35px 15px 35px;
  background: #fff;
  border: 1px solid #eaeaea;
  box-shadow: 0 0 25px #cac6c6;
}

.login_title {
  margin: 0px auto 40px auto;
  text-align: center;
  color: #505458;
}

.login_remember {
  margin: 0px 0px 35px 0px;
  text-align: left;
}
</style>
<template>
  <div id="left-content" style="height:100%;width:100% ;font-size:20px">
    <el-row class="tac">
      <el-col :span="3">
        <el-menu
          :default-active="$route.path"
          class="el-menu-vertical-demo"
          background-color="#545c64"
          text-color="#fff"
          active-text-color="#ffd04b"
          router
        >
          <div class="touxaing-contain">
            <div class="touxaing-contain-img">
              <img src="../assets/logo.png" alt style="width:100px;height:100px" srcset />
            </div>
          </div>
          <el-menu-item index="home">
            <i class="el-icon-menu"></i>
            <span slot="title">我的</span>
            <router-view />
          </el-menu-item>
          <el-menu-item index="2">
            <i class="el-icon-menu"></i>
            <span slot="title">工作任务</span>
          </el-menu-item>
          <el-menu-item index="3">
            <i class="el-icon-menu"></i>
            <span slot="title">工作流</span>
          </el-menu-item>
        </el-menu>
      </el-col>
    </el-row>
    <!-- <div id="right-content" style="float:right">
      <router-view />
    </div>-->
  </div>
</template>

<script>
export default {
  components: {
    Home
  },
  data() {
    return {
      profile: { name: "", position: "" }
    };
  },
  methods: {
    created() {
      this.show();

      // console.log(this.msg)
      // this.show()
    },
    show() {
      var user_id = this.store.getters.token();
      // 这是遇到的第二个生命周期函数
      alert(user_id, "aaaaaaa");
    }
  }
};
</script>

<style lang="less" scoped>
.el-menu-vertical-demo {
  width: 15%;
  height: 937px;
}
.touxaing-contain {
  width: 100%;
  height: 100px;
  .touxaing-contain-img {
    width: 100px;
    height: 100px;
    border-radius: 50%;
    img {
      margin-left: 20%;
      //transform: translate(-50%,-50%)
    }
  }
}
.presonal-profile {
  height: 100px;
  width: 100%;
  color: aliceblue;
  text-align: center;
}
</style>
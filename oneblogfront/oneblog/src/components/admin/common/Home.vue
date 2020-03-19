<template>
  <div class="wrapper">
    <oa-Head></oa-Head>
    <oa-Siderbar></oa-Siderbar>
    <div class="content-box" :class="{'content-collapse':collapse}">
      <!-- <v-tags></v-tags> -->
      <div class="content">
        <transition name="move" mode="out-in">
            <router-view></router-view>
          <!-- <keep-alive :include="tagsList">
            
          </keep-alive> -->
        </transition>
        <el-backtop target=".content"></el-backtop>
      </div>
    </div>
  </div>
</template>

<script>
import oaHead from './Header.vue';
import oaSiderbar from './Siderbar.vue';

export default {
  data() {
    return {
      tagsList: [],
      collapse: false
    };
  },
  components: {
    oaHead,
    oaSiderbar
  },
  
};
</script>

<style>
</style>
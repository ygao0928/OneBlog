<template>
  <div class="sidebar">
        <el-menu
            class="sidebar-el-menu"
            default-active="/index"
            :collapse="collapse"
            background-color="#324157"
            text-color="#bfcbd9"
            active-text-color="#20a0ff"
            @open="handleOpen" @close="handleClose"
            unique-opened
            router
        >
            <template v-for="item in items">
                <template v-if="item.subs">
                    <el-submenu :index="item.index" :key="item.index">
                        <template slot="title">
                            <i :class="item.icon"></i>
                            <span slot="title">{{ item.title }}</span>
                        </template>
                        <template v-for="subItem in item.subs">
                            <el-submenu
                                v-if="subItem.subs"
                                :index="subItem.index"
                                :key="subItem.index"
                            >
                                <template slot="title">{{ subItem.title }}</template>
                                <el-menu-item
                                    v-for="(threeItem,i) in subItem.subs"
                                    :key="i"
                                    :index="threeItem.index"
                                >{{ threeItem.title }}</el-menu-item>
                            </el-submenu>
                            <el-menu-item
                                v-else
                                :index="subItem.index"
                                :key="subItem.index"
                            >{{ subItem.title }}</el-menu-item>
                        </template>
                    </el-submenu>
                </template>
                <template v-else>
                    <el-menu-item :index="item.index" :key="item.index">
                        <i :class="item.icon"></i>
                        <span slot="title">{{ item.title }}</span>
                    </el-menu-item>
                </template>
            </template>
        </el-menu>
    </div>
</template>

<script>
import bus from './bus.js';
export default {
    data() {
        return {
            collapse: false,
            items:[
                {
                    icon: 'el-icon-user',
                    index: '1-2',
                    title: '文章',
                    subs:[
                        {
                            index:'/index',
                            title:'文章信息'
                        },
                         {
                            index:'/addartice',
                            title:'新增文章'
                        }
                    ]
                },
                {
                    icon: 'el-icon-suitcase',
                    index: '2-1',
                    title: '标签',
                    subs:[
                        {
                            index:'/tag',
                            title:'标签'
                        }
                    ]
                   
                },
                {
                    icon: 'el-icon-s-promotion',
                    index: '3-1',
                    title: '用户',
                    subs:[
                        {
                            index:'/user',
                            title:'标签'
                        }
                    ]
                }
            ]
        }
    },
    methods:{
        handleOpen(){},
        handleClose(){}
    }
}
</script>

<style>
.sidebar {
    display: block;
    position: absolute;
    left: 0;
    top: 70px;
    bottom: 0;
    overflow-y: scroll;
}
.sidebar::-webkit-scrollbar {
    width: 0;
}
.sidebar-el-menu:not(.el-menu--collapse) {
    width: 270px;
}
.sidebar > ul {
    height: 100%;
}
</style>
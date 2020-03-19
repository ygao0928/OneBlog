<template>
  <div class="add-artice">
    <div class="add-artice-top">
      <el-form :rules="rules" ref="articlFrom">
        <el-form-item label="文章标题" prop="articleName">
          <el-input class="artname-input" v-model="articlFrom.articleName" placeholder="文章主题"></el-input>
        </el-form-item>
        <el-form-item label="文章标签" prop="tagName">
          <el-input class="tag-input" v-model="articlFrom.articleName" placeholder="文章标签">
            <el-tag>标签一</el-tag>
          </el-input>
        </el-form-item>
      </el-form>
      
    </div>

    <div class="tag-container">
      <el-tag class="tag-span" v-for="item in tagList" :key="item.id" @click="dynamicAdd">{{item.tag}}</el-tag>
    </div>
    <el-button type="primary" @click.native.prevent="saveArticle">保存</el-button>
    <mavon-editor
      :toolbars="toolbars"
      @imgAdd="handleEditorImgAdd"
      @imgDel="handleEditorImgDel"
      style="height:100%"
      v-model="value"
      @change="change"
      ref="md"
    />
  </div>
</template>

<script>
export default {
  htmlcont: "",
  textcont: "",
  data() {
    return {
      articlFrom: {
        articleName: "",
        tagName:''
      },
      rules: {
        articleName: [
          { required: true, message: "请输入标题", trigger: "blur" }
        ],tagName: [
          { required: true, message: "请输入标签", trigger: "blur" }
        ]
      },
      tagList: [],
      value: "",

      toolbars: {
        bold: true, // 粗体
        italic: true, // 斜体
        header: true, // 标题
        underline: true, // 下划线
        strikethrough: true, // 中划线
        mark: true, // 标记
        superscript: true, // 上角标
        subscript: true, // 下角标
        quote: true, // 引用
        ol: true, // 有序列表
        ul: true, // 无序列表
        link: true, // 链接
        imagelink: true, // 图片链接
        code: false, // code
        table: true, // 表格
        fullscreen: true, // 全屏编辑
        readmodel: true, // 沉浸式阅读
        htmlcode: true, // 展示html源码
        help: true, // 帮助
        /* 1.3.5 */
        undo: true, // 上一步
        redo: true, // 下一步
        trash: true, // 清空
        save: true, // 保存（触发events中的save事件）
        /* 1.4.2 */
        navigation: true, // 导航目录
        /* 2.1.8 */
        alignleft: true, // 左对齐
        aligncenter: true, // 居中
        alignright: true, // 右对齐
        /* 2.2.1 */
        subfield: true, // 单双栏模式
        preview: true // 预览
      }
    };
  },
  created() {
    this.findAllTag();
  },
  methods: {
    //监听markdown变化
    change(value, render) {
      this.contentHtml = render;

      this.textcontent = value;
      this.htmlcont = this.contentHtml;
      this.textcont = this.textcontent;

      // this.blogInfo.blogMdContent = value;
      // this.blogInfo.blogContent = render;
      // console.log(render);
    },
    //上传图片接口pos 表示第几个图片
    handleEditorImgAdd(pos, $file) {
      // var formdata = new FormData();
      // formdata.append('file' , $file);
      //  this.$axios
      // .post("http://localhost:8000/blogs/image/upload/", formdata)
      // .then(res => {
      //   var url = res.data.data;
      //    this.$refs.md.$img2Url(pos, url);  //这里就是引用ref = md 然后调用$img2Url方法即可替换地址
      // });
    },
    handleEditorImgDel() {
      console.log("handleEditorImgDel"); //我这里没做什么操作，后续我要写上接口，从七牛云CDN删除相应的图片
    },

    saveArticle() {
      this.$postRequest("/article/add", {
        title: this.articleName,
        htmlContent: this.htmlcont,
        textContent: this.textcont,
        tag: "标签"
      }).then(resp => {
        console.log(resp);
      });
    },
    findAllTag() {
      this.$postRequest("/article/findAllTag", {}).then(resp => {
        this.tagList = resp.data.data;
        console.log(resp.data.data);
      });
    },
    dynamicAdd(){

    }
  }
};
</script>

<style>
.add-artice-top{
  padding:20px;
}
.artname-input ,.tag-input{
  width: 20%;
}
.add-artice {
  background-color: white;
  height: 100%;
  width: 100%;
}
.title {
  width: 60px;
}
.tag-container {
  height: 40px;
  width: 40%;
  padding: 20px;
}
.tag-span {
  border: 1px solid #444;
  border-radius: 5px;
  margin: 5px;cursor: pointer;
}

</style>
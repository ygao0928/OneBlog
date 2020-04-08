<template>
  <el-table
    :data="tableData"
    style="width: 70%">
    <el-table-column
      prop="createrOn"
      label="日期"
      width="180">
    </el-table-column>
    <el-table-column
      prop="aritcleName"
      label="文章标题"
      width="180">
    </el-table-column>
    <el-table-column
      prop="creater"
      label="发布者">
    </el-table-column>
    <el-table-column
      prop="textContent"
      label="发布内容"
      width="180">
    </el-table-column>
  </el-table>
</template>
<script>
  export default {
    data() {
      return {
        tableData: []
      }
    }, created() {
      this.showAllArticles();
    },
    methods: {
      showAllArticles() {
        let _this = this
        this.$postRequest("/article/findAllArticle").then(resp => {
          let respdata = resp.data.data
          for (let i = 0; i < respdata.length; i++) {
            _this.tableData.push(respdata[i])
          }

        })
      }
    }
  }
</script>

<style>

</style>

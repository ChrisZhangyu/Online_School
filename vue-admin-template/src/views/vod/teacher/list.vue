<template>
    <div class="app-container">
        <el-card class="operate-container" shadow="never">
  <el-form :inline="true" class="demo-form-inline">
  <el-form-item label="名称">
    <el-input v-model="query.name" placeholder="讲师名" /> 
  </el-form-item>

  <el-form-item label="头衔">
    <el-select v-model="query.level" clearable placeholder="头衔">
      <el-option value="1" label="高级讲师"/>
      <el-option value="0" label="首席讲师"/>
    </el-select>
  </el-form-item>

  <el-form-item label="入驻时间">
    <el-date-picker
      v-model="query.joinDateBegin"
      placeholder="开始时间"
      value-format="yyyy-MM-dd" />
  </el-form-item>
  <el-form-item label="-">
    <el-date-picker
      v-model="query.joinDateEnd"
      placeholder="结束时间"
      value-format="yyyy-MM-dd" />
  </el-form-item>

    <el-button type="primary" icon="el-icon-search" @click="fetchData()">查询</el-button>
    <el-button type="default" @click="resetData()">清空</el-button>
</el-form>

<el-card class="operate-container" shadow="never">
  <i class="el-icon-tickets" style="margin-top: 5px"></i>
  <span style="margin-top: 5px">数据列表</span>
  <el-button class="btn-add" @click="add()" style="margin-left: 10px;">添加</el-button>
  <el-button class="btn-add" @click="batchDelete()" >批量删除</el-button>
</el-card>

</el-card>

  <el-table
  :data="list"
  border
  stripe
  @selection-change="handleSelectionChange">
  <el-table-column type="selection"/>
  <el-table-column
    label="#"
    width="50">
    <template slot-scope="scope">
      {{ (page - 1) * limit + scope.$index + 1 }}
    </template>
  </el-table-column>
  <el-table-column prop="name" label="名称" width="80" />
  <el-table-column label="头衔" width="90">
    <template slot-scope="scope">
      <el-tag v-if="scope.row.level === 1" type="success" size="mini">高级讲师</el-tag>
      <el-tag v-if="scope.row.level === 2" size="mini">首席讲师</el-tag>
    </template>
  </el-table-column>
  <el-table-column prop="intro" label="简介" />
  <el-table-column prop="sort" label="排序" width="60" />
  <el-table-column prop="joinDate" label="入驻时间" width="160" />
  <el-table-column label="操作" width="200" align="center">
    <template slot-scope="scope">
      <el-button type="text" size="mini" @click="deleteById(scope.row.id)">删除</el-button>
      <router-link :to="'/teacher/edit/'+scope.row.id">
        <el-button type="text" size="mini">修改</el-button>
      </router-link>
    </template>
  </el-table-column>
</el-table>

<!-- 分页导航组件 -->
<el-pagination
    :current-page="page"
    :total="total"
    :page-size="limit"
    :page-sizes="[5, 10, 20, 30, 40, 50, 100]"
    style="padding: 30px 0; text-align: center;"
    layout="total, sizes, prev, pager, next, jumper"
    @size-change="changePageSize"
    @current-change="changeCurrentPage"
  />
</div>

   
</template>

<script>
import teacherApi from '@/api/vod/teacher'

export default {
    data() {
        return {
      list: [], // 讲师列表
      total: 0, // 总记录数
      page: 1, // 页码
      limit: 10, // 每页记录数
      query: {}, // 查询条件
      multipleSelection: []// 批量删除选中的记录列表
    }
    },
    created() {
        this.fetchData()
    },
    methods: {
        fetchData() {
            // 调用api
            teacherApi.pageList(this.page, this.limit, this.query)
            .then(
                response =>{
                    this.list = response.data.records
                    this.total = response.data.total
                }
            )
        },
        changePageSize(size) {
            console.log(size)
            this.limit = size
            this.fetchData()
        },
        changeCurrentPage(page) {
            console.log(page)
            this.page = page
            this.fetchData()
        },
        resetData() {
           this.query = {}
            this.fetchData()
        },
        deleteById(id){
            this.$confirm('此操作将永久删除该记录, 是否继续?', '提示', {
            confirmButtonText: '确定',
            cancelButtonText: '取消',
            type: 'warning'
                }).then(() => {
                    return teacherApi.deleteTeacher(id)
                }).then((response) => {
                    this.fetchData()
                    this.$message.success(response.message)
                })
        },
        batchDelete() {
          if(this.multipleSelection.length === 0){
              this.$message.warning("请选择要删除的记录!")
              return
          }
          this.$confirm("此操作将永久删除该记录, 是否继续?", "提示", {
              confirmButtonText: "确认",
              cancelButtonText: "取消",
              type: "warning"
            }).then( () => {
            // 点击确定，远程调用ajax
            // 遍历selection，将id取出放入id列表
            console.log("aaa")
            var idList = []
            

            this.multipleSelection.forEach(item => {
                idList.push(item.id)
            })
            console.log(idList)
            // 调用api
              return teacherApi.batchDeleteTeacher(idList) 
            }).then(response => {
              // 刷新页面，重新读数据
              this.fetchData()
              this.$message.success(response.message)
            }).catch(error => {
              if (error === 'cancel') {
                this.$message.info('取消删除')
              }
          })
        },

        handleSelectionChange(selection) {
          this.multipleSelection = selection
          // console.log(this.multipleSelection)
          // console.log(this.multipleSelection.length)
        },
        add() {
          this.$router.push({path: "/teacher/create"})
        }
        
    }
}
</script>


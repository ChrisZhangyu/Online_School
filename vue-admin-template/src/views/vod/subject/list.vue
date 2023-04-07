<template>
     <div  class="app-container">
        <el-table
            :data="list"
            style="width: 100%"
            row-key="id"
            border
            lazy
            :load="load"
            :tree-props="{children: 'children', hasChildren: 'hasChildren'}">
            <el-table-column
            prop="title"
            label="名称"
            width="150">
            </el-table-column>
            <el-table-column
            prop="createTime"
            label="创建时间">
            </el-table-column>
        </el-table>
        <div class="el-toolbar">
            <div class="el-toolbar-body" style="justify-content: flex-start;">
              <el-button type="text" @click="exportData"><i class="fa fa-plus"/> 导出</el-button>
              <el-button type="text" @click="importData"><i class="fa fa-plus"/> 导入</el-button>
        </div>
       
      </div>
      <el-dialog title="导入" :visible.sync="dialogImportVisible" width="480px">
        <el-form label-position="right" label-width="170px">
            <el-form-item label="文件">
                <el-upload
                          :multiple="false"
                          :on-success="onUploadSuccess"
                          :action="'http://localhost:8301/admin/vod/subject/importData'" 
                          class="upload-demo">
                    <el-button size="small" type="primary">点击上传</el-button>
                    <div slot="tip" class="el-upload__tip">只能上传xls文件，且不超过500kb</div>
                </el-upload>
            </el-form-item>
          </el-form>
          <div slot="footer" class="dialog-footer">
              <el-button @click="dialogImportVisible = false">取消</el-button>
          </div>
      </el-dialog>
      
    </div>

  </template>

<script>
    import subjectApi from "@/api/vod/subject"
      export default {
        data() {
          return {
            dialogImportVisible: false, //导入对话框初始不可见，调用方法可见
            list: [] //数据字典列表数组
        }},
        created() {
          this.getSubjectList(0)
        },
        methods: {
          getSubjectList(id) {
           subjectApi.getSubjectList(id).then(response => {
              this.list = response.data
           })
          },

          load(tree, treeNode, resolve) {
            subjectApi.getSubjectList(tree.id).then(response => {
              resolve(response.data)
            })
          },
          exportData() {
            // console.log(`**********************`)

            // console.log(`**********************${this.$refs.elTable.treeP}`)
            window.open("http://localhost:8301/admin/vod/subject/exportData")
          },
          importData() {
          
            // 弹出对话框
            this.dialogImportVisible = true
            
          },
          onUploadSuccess() {
            // 显示提示
            this.$message.info("上传成功")
            // 使对话框消失
            this.dialogImportVisible = false
            // 重新查询数据（刷新数据）
            this.getSubjectList(0)
            
          },
          
        },
       
      }
    </script>
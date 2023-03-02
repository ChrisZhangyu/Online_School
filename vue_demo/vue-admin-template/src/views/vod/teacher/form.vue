<template>
    <div class="app-container">
        <template>
  <div class="app-container">
    <!-- 输入表单 -->
    <el-form label-width="120px">
      <el-form-item label="讲师名称">
        <el-input v-model="teacher.name" />
      </el-form-item>
      <el-form-item label="入驻时间">
        <el-date-picker v-model="teacher.joinDate" value-format="yyyy-MM-dd" />
      </el-form-item>
      <el-form-item label="讲师排序">
        <el-input-number v-model="teacher.sort" :min="0"/>
      </el-form-item>
      <el-form-item label="讲师头衔">
        <el-select v-model="teacher.level">
          <!--
            数据类型一定要和取出的json中的一致，否则没法回填
            因此，这里value使用动态绑定的值，保证其数据类型是number
            -->
          <el-option :value="1" label="高级讲师"/>
          <el-option :value="2" label="首席讲师"/>
        </el-select>
      </el-form-item>
      <el-form-item label="讲师简介">
        <el-input v-model="teacher.intro"/>
      </el-form-item>
      <el-form-item label="讲师资历">
        <el-input v-model="teacher.career" :rows="10" type="textarea"/>
      </el-form-item>

      <!-- 讲师头像 -->
      <el-form-item label="讲师头像">
      </el-form-item>

      <el-form-item>
        <el-button type="primary" @click="saveOrUpdate()">保存</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>
    </div>
</template>

<script>
import teacherApi from "@/api/vod/teacher"
export default{
    data() {
        return{
            teacher: {
            sort: 0,
            level: 2,
        },
        }
        
    },
    created() {
        // 查看到本页面的路由是否有id参数，有则说明是修改，无则是添加
        if(this.$route.params.id){
           this.fetchDataById(this.$route.params.id)

        }
    },
    methods: {
        save() {
            teacherApi.saveTeacher(this.teacher)
            .then(response => {
                // 提示语句
                this.$message.success("添加成功")
                this.$router.push({ path: '/vod/teacher/list'})
            })
        },
        update() {
            teacherApi.updateTeacher(this.teacher)
            .then(response => {
                // 提示语句
                this.$message.success("修改成功")
                this.$router.push({ path: '/vod/teacher/list'})
            })
        },
        saveOrUpdate(){
            if(this.$route.params.id) {
                this.update()
            }else {
                this.save()
            }
        },
        fetchDataById(id) {
            teacherApi.fetchTeacherById(id)
            .then(response => {
                this.teacher = response.data
            })
        }
    }
}
</script>
import request from "@/utils/request"

const api_url = "/admin/vod/course"

export default {
    getCoursePage(currPage, limit, query){
        return request({
            url: `${api_url}/courseList/${currPage}/${limit}`,
            method: "get",
            params: query
        })
    },
    getCourseById(id){
        return request({
            url: `${api_url}/get/${id}`,
            method: "get",
            
        })
    },
    saveCourseInfo(courseInfo){
        return request({
            url: `${api_url}/add`,
            method: "post",
            data: courseInfo
        })
    },
    updateCourseInfo(courseInfo) {
        return request({
          url: `${api_url}/update`,
          method: 'put',
          data: courseInfo
        })
      },
    getCoursePublishById(id){
        return request({
            url: `${api_url}/getPublish/${id}`,
            method: "get"
        })
    },
    removeById(id){
        return request({
            url: `${api_url}/remove/${id}`,
            method: "delete"
        })
    }
}
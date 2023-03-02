import request from "@/utils/request"

const api_url = "/admin/vod/teacher"
export default{
    pageList(currPage, limit, query){
        return request({
            url: `${api_url}/findQueryPage/${currPage}/${limit}`,
            method: "post",
            data: query
        })
    },
    deleteTeacher(id){
        return request({
            url: `${api_url}/remove/${id}`,
            method: "delete",
        })
    },
    saveTeacher(teacher){
        return request({
            url: `${api_url}/save`,
            method: "put",
            data: teacher
        })
    },
    updateTeacher(teacher){
        return request({
            url: `${api_url}/update`,
            method: "post",
            data: teacher
        })
    },
    fetchTeacherById(id){
        return request({
            url: `${api_url}/get/${id}`,
            method: "get",
        })
    },
    batchDeleteTeacher(idList){
        return request({
            url: `${api_url}/batchDeleteTeacher`,
            method: "delete",
            data: idList
        })
    },
    findAllTeacher(){
        return request({
            url: `${api_url}/findAll`,
            method: "get"

        })
    }
}
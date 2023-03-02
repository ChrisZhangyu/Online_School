import request from "@/utils/request"
const api_url = "/admin/vod/subject"

export default {
    getSubjectList(id) {
        return request({
            url: `${api_url}/getSubjectsAndChild/${id}`,
            method: "get"
        })
    }
}
import request from "@/utils/request"

const api_name = '/admin/vod/videoVisitor'
export default {
    getCount(courseId, startDate, endDate){
        return request({
            url: `${api_name}/getCount/${courseId}/${startDate}/${endDate}`,
            method: "get"
        })
    }
}
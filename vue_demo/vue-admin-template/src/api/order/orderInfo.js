import request from "@/utils/request"

const api_name = '/admin/order/orderInfo'

export default {
    getPage(limit, currPage, query){
        return request({
            url: `${api_name}/getPage/${limit}/${currPage}`,
            method: "get",
            data: query
        })
    }
}
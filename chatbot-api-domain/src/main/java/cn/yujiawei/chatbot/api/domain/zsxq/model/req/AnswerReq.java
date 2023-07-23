package cn.yujiawei.chatbot.api.domain.zsxq.model.req;

/**
 * @author yu
 * @date 2023/7/23
 * @description 请求问答接口信息
 */
public class AnswerReq {
    private ReqData req_data;


    public ReqData getReq_data() {
        return req_data;
    }

    public void setReq_data(ReqData req_data) {
        this.req_data = req_data;
    }

    public AnswerReq(ReqData req_data) {
        this.req_data = req_data;
    }
}

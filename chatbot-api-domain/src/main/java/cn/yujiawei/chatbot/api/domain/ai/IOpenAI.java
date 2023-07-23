package cn.yujiawei.chatbot.api.domain.ai;

import java.io.IOException;

/**
 * @author yu
 * @date 2023/7/23
 * @description ChatGPT OpenAI 接口
 */
public interface IOpenAI {

    String doChatGPT(String question) throws IOException;
}

package cn.yujiawei.chatbot.api.test;

import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;

/**
 * @author yu
 * @date 2023/7/23
 * @description 单元测试
 */
public class ApiTest {

    @Test
    public void query_unanswered_questions() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpGet get = new HttpGet("https://api.zsxq.com/v2/groups/15552114212182/topics?scope=unanswered_questions&count=20");

        get.addHeader("cookie","zsxq_access_token=BFB7D723-74F6-CC34-5DFA-2B02C5CA7FF8_11B2782A765AEA5D; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22188fd8cd47cb54-0fbe0d10394f6f-1b525634-2073600-188fd8cd47dd2b%22%2C%22first_id%22%3A%22%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24latest_referrer%22%3A%22%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTg4ZmQ4Y2Q0N2NiNTQtMGZiZTBkMTAzOTRmNmYtMWI1MjU2MzQtMjA3MzYwMC0xODhmZDhjZDQ3ZGQyYiJ9%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%22%2C%22value%22%3A%22%22%7D%2C%22%24device_id%22%3A%22188fd8cd47cb54-0fbe0d10394f6f-1b525634-2073600-188fd8cd47dd2b%22%7D; abtest_env=product; zsxqsessionid=e544eccc758206c91011408f3fee8ce0");
        get.addHeader("Content-Type","application/json;charset=utf8");

        CloseableHttpResponse response = httpClient.execute(get);
        if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        }else{
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }
    @Test
    public void answer() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpPost post = new HttpPost("https://api.zsxq.com/v2/topics/588125221858524/answer");
        post.addHeader("cookie","zsxq_access_token=BFB7D723-74F6-CC34-5DFA-2B02C5CA7FF8_11B2782A765AEA5D; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22188fd8cd47cb54-0fbe0d10394f6f-1b525634-2073600-188fd8cd47dd2b%22%2C%22first_id%22%3A%22%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24latest_referrer%22%3A%22%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTg4ZmQ4Y2Q0N2NiNTQtMGZiZTBkMTAzOTRmNmYtMWI1MjU2MzQtMjA3MzYwMC0xODhmZDhjZDQ3ZGQyYiJ9%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%22%2C%22value%22%3A%22%22%7D%2C%22%24device_id%22%3A%22188fd8cd47cb54-0fbe0d10394f6f-1b525634-2073600-188fd8cd47dd2b%22%7D; abtest_env=product; zsxqsessionid=e544eccc758206c91011408f3fee8ce0");
        post.addHeader("Content-Type","application/json;charset=utf8");

        String paramJson = "{\n" +
                "  \"req_data\": {\n" +
                "    \"text\": \"测试回答2\\n\",\n" +
                "    \"image_ids\": [],\n" +
                "    \"silenced\": true\n" +
                "  }\n" +
                "}";

        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("text/json", "UTF-8"));

        post.setEntity(stringEntity);
        CloseableHttpResponse response = httpClient.execute(post);


        // 反馈
        if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        }else{
            System.out.println(response.getStatusLine().getStatusCode());
        }



    }
}

package cn.maxlu.netty.demo.http.client;

/**
 * Created by luwei on 2017/6/8.
 */
public class HttpClientTest {
    public static void main(String[] args) throws Exception {
        HttpClient client = HttpClient.get();
        String result = client.connect("127.0.0.1", 8080).send("hello world");
        System.out.println(result);
    }
}

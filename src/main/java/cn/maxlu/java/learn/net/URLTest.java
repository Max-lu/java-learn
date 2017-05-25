package cn.maxlu.java.learn.net;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by lw on 2016/7/18.
 */

public class URLTest {

    public static void main(String[] args) throws Exception {
        URL url = new URL("https://github.com");
        URLConnection connection = url.openConnection();

        HttpURLConnection httpURLConnection;
        if (connection instanceof HttpURLConnection) {
            httpURLConnection = (HttpURLConnection) connection;
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setInstanceFollowRedirects(true);
            httpURLConnection.setRequestProperty("content-type", "text/html");
            httpURLConnection.setRequestProperty("Accept-Charset", "utf-8");
        } else {
            System.out.println("protocol is not supported");
            return;
        }
        //httpURLConnection.connect();

        System.err.println(httpURLConnection.getResponseCode());
        System.err.println(httpURLConnection.getResponseMessage());

        InputStream urlStream = httpURLConnection.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(urlStream, "utf-8"));
        StringBuffer strBuffer = new StringBuffer();
        String line;
        while ((line = reader.readLine()) != null) {
            strBuffer.append(line).append("\n");
        }

        System.out.println(strBuffer);

//        FileWriter writer = new FileWriter("data/tmp");
//        writer.write(strBuffer.toString());
    }

    private static void m1() throws MalformedURLException {
        URL url = new URL("http://www.runoob.com/index.html?language=cn#j2se");
        System.out.println("URL 为：" + url.toString());
        System.out.println("协议为：" + url.getProtocol());
        System.out.println("验证信息：" + url.getAuthority());
        System.out.println("文件名及请求参数：" + url.getFile());
        System.out.println("主机名：" + url.getHost());
        System.out.println("路径：" + url.getPath());
        System.out.println("端口：" + url.getPort());
        System.out.println("默认端口：" + url.getDefaultPort());
        System.out.println("请求参数：" + url.getQuery());
        System.out.println("定位位置：" + url.getRef());
    }


}

package com.util;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * 根据URL获取url相对应的内容
 * Created by Lin on 2017/4/1.
 */
public class PageUtil {

    public static String getContent(String url) {
        HttpClientBuilder custom = HttpClients.custom();
        //构建一个httpclient对象，获取一个浏览器对象
        CloseableHttpClient build = custom.build();
        HttpGet httpGet = new HttpGet(url);
        String content = null;
        try {
            //使用client执行get请求，获取请求的结果，请求的结果被封装到response中
            CloseableHttpResponse response = build.execute(httpGet);
            //表示获取返回内容的实体对象
            HttpEntity entity = response.getEntity();
            content = EntityUtils.toString(entity);

        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }
}

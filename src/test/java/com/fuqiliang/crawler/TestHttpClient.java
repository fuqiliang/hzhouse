package com.fuqiliang.crawler;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestHttpClient {
    public String post(String url, Map<String, String> params){
        //实例化httpClient
        CloseableHttpClient httpclient = HttpClients.createDefault();
        //实例化post方法
        HttpPost httpPost = new HttpPost(url);
        //处理参数
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        Set<String> keySet = params.keySet();
        for(String key : keySet) {
            nvps.add(new BasicNameValuePair(key, params.get(key)));
        }
        //结果
        CloseableHttpResponse response = null;
        String content="";
        try {
            //提交的参数
            UrlEncodedFormEntity uefEntity  = new UrlEncodedFormEntity(nvps, "UTF-8");
            //将参数给post方法
            httpPost.setEntity(uefEntity);

            RequestConfig.Builder builder = RequestConfig.custom()
                    .setSocketTimeout(10000);
            httpPost.setConfig(builder.build());

            //执行post方法
            response = httpclient.execute(httpPost);
            if(response.getStatusLine().getStatusCode()==200){
                content = EntityUtils.toString(response.getEntity(),"utf-8");
                System.out.println(content);
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }
    public static void main(String[] args) {

        TestHttpClient client = new TestHttpClient();

        Map<String, String> fields = new HashMap<>();
        fields.put("signid","ff80808166484c980166486b4e0b0023");
        fields.put("threshold","ff80808166484c980166486b4e0b0021");
        fields.put("salt","ff80808166484c980166486b4e0b0022");
        fields.put("nonce","0");
        fields.put("hash","0448c9b2298cc81d7e0b7a2ab77fcd9261f956537b0939664985b08a1bc4ce20");
        fields.put("page","856");
        client.post("http://jjhygl.hzfc.gov.cn/webty/WebFyAction_getGpxxSelectList.jspx",fields);
    }
}

package com.example.demo;

import com.example.demo.util.JsonUtil;
import org.apache.http.HttpConnection;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Test1 {
    public static void main(String[] args) throws IOException {

        String json = JsonUtil.objectToString("aaa");
        System.out.println(json);

        String url = "https://www.baidu.com";
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse response = httpClientBuilder.build().execute(httpGet);

        HttpEntity entity = response.getEntity();

        System.out.println("-----------------------");
        String s1 = EntityUtils.toString(entity, "utf-8");
        System.out.println(s1);
        httpGet.releaseConnection();
        System.out.println("start...");
        Document parse1 = Jsoup.parse(s1);
        System.out.println(parse1);

//        Document doc= Jsoup.connect(url).get();
//        System.out.println(doc.text());

        Date date = new Date();
        java.sql.Date date1 = new java.sql.Date(date.getTime());
        System.out.println(date);
        System.out.println(date1);
        LocalDate localDate = LocalDate.now();
        LocalTime now = LocalTime.now();
        System.out.println("localDate:" + localDate);
        System.out.println("localTime:" + now);


        LocalDateTime localDateTime = LocalDateTime.now();
        String format = localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
//        与上面转换等价
//        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//        String format = dateTimeFormatter.format(localDateTime);
        System.out.println(localDateTime);
        System.out.println(format);


        LocalDateTime parse = LocalDateTime.parse(format, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println(parse);


    }
}

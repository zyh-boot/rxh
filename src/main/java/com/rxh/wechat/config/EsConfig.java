package com.rxh.wechat.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @Description:
 * @Author Zhang YuHui 
 * @Date 2020/11/24 18:20
 *
 */
//@Configuration
public class EsConfig {

    @Bean
    public RestClientBuilder builder(){
        HttpHost httpHost = new HttpHost("127.0.0.1",9200,"http");
        return RestClient.builder(httpHost);
    }

    @Bean
    public RestHighLevelClient restHighLevelClient(@Autowired  RestClientBuilder restClientBuilder){
        return  new RestHighLevelClient(restClientBuilder);
    }
}

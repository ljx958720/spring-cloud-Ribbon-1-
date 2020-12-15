package com.ghy.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.ServiceInstance;

@RestController
public class RestTemplateUser {

    @Autowired
    RestTemplate restTemplate;

    //因为RestTemplate不存在所以要注入
//    @Bean
//    public RestTemplate restTemplate(){
//        return new RestTemplate();
//    }
//    @Bean
//    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder){
//        return restTemplateBuilder.build();
//    }
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder){
        return restTemplateBuilder.build();
    }

//    @Autowired
//    LoadBalancerClient loadBalancerClient;


    @GetMapping("/user")
    public String findById(){

//        ServiceInstance serviceInstance=loadBalancerClient.choose("spring-cloud-server");
//        String url=String.format("http://%s:%s",serviceInstance.getHost(),serviceInstance.getPort()+"/orders");
//        return restTemplate.getForObject(url,String.class);
        //通过服务名称在配置文件中选择端口调用
       return restTemplate.getForObject("http://spring-cloud-server/orders",String.class);
    }
}

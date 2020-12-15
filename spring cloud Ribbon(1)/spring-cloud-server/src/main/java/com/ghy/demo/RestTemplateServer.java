package com.ghy.demo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestTemplateServer {
    @Value("${server.port}")
    private int port;

    @GetMapping("/orders")
    public String getAllOrder(){
        System.out.println("port:"+port);
        return "测试成功";
    }
}

package com.ghy.demo.Qualifier;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//@Configuration用于定义配置类，可替换xml配置文件，
// 被注解的类内部包含有一个或多个被@Bean注解的方法，
// 这些方法将会被AnnotationConfigApplicationContext或
// AnnotationConfigWebApplicationContext类进行扫描，
// 并用于构建bean定义，初始化Spring容器。
@Configuration
public class QualifierConfiguration {
    //@Qualifier
    @Bean("QualifierTest1")
    QualifierTest QualifierTest1(){
        return new QualifierTest("QualifierTest1");
    }

    @Qualifier
    @Bean("QualifierTest2")
    QualifierTest QualifierTest2(){
        return new QualifierTest("QualifierTest2");
    }
}

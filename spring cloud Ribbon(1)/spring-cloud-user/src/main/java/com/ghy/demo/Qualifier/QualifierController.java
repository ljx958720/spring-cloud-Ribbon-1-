package com.ghy.demo.Qualifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
@RestController
public class QualifierController {
    //@Qualifier作用是找到所有申明@Qualifier标记的实例
    @Qualifier
    @Autowired
    List<QualifierTest> testClassList= Collections.emptyList();

    @GetMapping("/qualifier")
    public Object test(){
        return testClassList;
    }
}

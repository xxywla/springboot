package com.xxyw.controller;

import com.xxyw.pojo.MyDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {

    @Value("${lesson}")
    private String myLesson;

    @Value("${enterprise.name}")
    private String myName;

    @Value(("${enterprise.hobbies[1]}"))
    private String myHobby;

    @Autowired
    private Environment env;

    @Autowired
    private MyDataSource myDataSource;

    @GetMapping
    public String getId() {
        System.out.println("Hello SpringBoot 你好");

        System.out.println("myLesson = " + myLesson);

        System.out.println("myName = " + myName);

        System.out.println("myHobby = " + myHobby);

        System.out.println("env.getProperty(\"enterprise.age\") = " + env.getProperty("enterprise.age"));

        System.out.println("myDataSource = " + myDataSource);

        return "Hello SpringBoot 你好";
    }
}

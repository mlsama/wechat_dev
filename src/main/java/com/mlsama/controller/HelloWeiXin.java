package com.mlsama.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * desc: 微信开发测试类
 * author：mlsama
 * dataTime:2018/4/1418:52
 */
@RestController
@Slf4j
public class HelloWeiXin {

    @GetMapping("/helloWeiXin")
    public String helloWeiXin(){
        return "HelloWeiXin";
    }
}

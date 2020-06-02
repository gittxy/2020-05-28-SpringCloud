package com.example.consumer;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {
    @Autowired(required = false)
    private FeignClientService feignClientService;

    @HystrixCommand(fallbackMethod = "executeHystrixHandle")
    @RequestMapping("/api/v1/demo/get")
    public String consumer(){
        //交给消费者处理
        return feignClientService.consumer();
    }

    //服务进入保护时，回调方法
    public String executeHystrixHandle() {
        return  "Hello, Server is currently congested, sorry , please try again later";
    }


}

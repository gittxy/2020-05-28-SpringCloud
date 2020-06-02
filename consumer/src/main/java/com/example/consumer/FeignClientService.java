package com.example.consumer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "producer")
public interface FeignClientService {

    @RequestMapping("/producer/demo")
    public String consumer();
}

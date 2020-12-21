package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

     @Autowired
    KafkaTemplate kafkaTemplate;

    @RequestMapping(value="/produce")
    public String getData(@RequestParam(value = "message", required = true, defaultValue = "") String message ){

        kafkaTemplate.send("sna-topic", "msg: " + message);

        //보낸메시지
        return message ;
    }


}

package src.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import src.service.HelloService;

@RestController
public class HelloController {

    public HelloController(){
        System.out.println("helloController init");
    }
    @Autowired
    HelloService helloService;

    @GetMapping("/hello")
    public String hello(){
        return "hello  " + helloService.getName();
    }
}

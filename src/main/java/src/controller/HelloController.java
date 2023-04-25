package src.controller;

import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.SpringServletContainerInitializer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;
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

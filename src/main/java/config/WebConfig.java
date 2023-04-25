package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

@Configuration //설정파일임을 명시
@ComponentScan("src") //같은폴더아니면 스캔위치 잡아야함.
public class WebConfig {
    public WebConfig(){
        System.out.println("WebConfig init");
    }
}

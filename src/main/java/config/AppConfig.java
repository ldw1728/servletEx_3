package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration //설정파일임을 명시
@ComponentScan //class들을 스캔하여 빈등록
public class AppConfig {
    public AppConfig(){
        System.out.println("init AppConfig");
    }
}

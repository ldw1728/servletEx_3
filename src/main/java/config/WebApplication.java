package config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class WebApplication implements WebApplicationInitializer {
    
    /**
     * webApplication이 초기화되는 시점에 실행
     * 매개변수에 servletContext을 사용하여 servletMapping, listener, Filter등의 설정 가능.
     * web.xml 설정파일 대체가능.
     * */
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        
        // filter 예시
        // addMappingForUrlPatterns() - filter 가 적용될 url 매핑
        servletContext.addFilter("utf8Filter", new CharacterEncodingFilter("UTF-8")).addMappingForUrlPatterns(null, false, "/*");

        // 1. annotation기반의 context생성
        AnnotationConfigWebApplicationContext annoContext = new AnnotationConfigWebApplicationContext();

        // 2. servletContext의 코드를 사용하는 경우를 위해 기본servletContext등록
        annoContext.setServletContext(servletContext);

        // 3. 설정파일 등록
        annoContext.register(WebConfig.class);
        annoContext.refresh();

        // 4. DispatcherServlet생성 및 annoContext 등록
        DispatcherServlet dispatcherServlet = new DispatcherServlet(annoContext);

        // 5. 기존 servletContext의 addServlet메소드로 DispatcherServlet을 추가하여 ServletRegistration 리턴
        ServletRegistration.Dynamic registration = servletContext.addServlet("app", dispatcherServlet);

        // 6. servlet url mapping...
        registration.addMapping("/");
    }
}

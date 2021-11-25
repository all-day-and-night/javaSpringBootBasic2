package hello.core;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

//ComponentScan @ Annotation이 붙은 모든 컴포넌트 스캔 and except prev Configuration in AppConfig
@Configuration
@ComponentScan(
        //
        //basePackages = "hello.core.member", 검색할 위치 지정 -> 추천 : 프로젝트의 최상단 위치 지정
        //basePackages = {"hello.core", "hello.service"} 여러 시작 위치 지정 가능
        basePackages = "hello.core",
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

}

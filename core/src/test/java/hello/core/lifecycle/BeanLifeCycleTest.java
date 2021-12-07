package hello.core.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest {


    @Test
    public void lifeCycleTest(){
        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        NetworkClient networkClient = ac.getBean(NetworkClient.class);
        ac.close();
    }

    @Configuration
    static class LifeCycleConfig{

        //Spring bean이 코드가 아니라 설정정보를 사용하기 때문에 외부 라이브러리에도 초기화, 종료 메서드를 사용할 수 있다.
        //스프링 빈이 스프링 코드에 의존하지 않는다다
       //@Bean(initMethod = "init", destroyMethod = "close")
        //또는 Annotation을 사용하여 해결할 수 있다.
       @Bean
        public NetworkClient networkClient(){
            NetworkClient networkClient = new NetworkClient();
            //아래 setUrl method는 생성자에서 시행되는데 이는 실행되지 않고 외부에서 데이터를 주입 받아야 한다.
            networkClient.setUrl("http://hello-spring.dev");
            return networkClient;
        }

    }
}

package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

public class StatefulServiceTest {
    @Test
    void statefulServiceSingleton(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

        StatefulService statefulService1 = ac.getBean("statefulService", StatefulService.class);
        StatefulService statefulService2 = ac.getBean("statefulService", StatefulService.class);

        //Thread A: A 사용자 10000원 주문
        statefulService1.order("userA", 10000);
        //Thread B: B 사용자 20000원 주문
        statefulService2.order("userB", 20000);

        //Thread A: A 사용자 주문 금액 조회
        int price = statefulService1.getPrice();

        System.out.println("price = " + price);
        //사용자 A는 10000원을 기대했지만 20000원 출력
        //같은 객체를 참조하기 때문에 2번째 statefulService에서 값 변환

        Assertions.assertThat(statefulService1.getPrice()).isEqualTo(statefulService2.getPrice());



    }


    static class TestConfig{
        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }
    }
}

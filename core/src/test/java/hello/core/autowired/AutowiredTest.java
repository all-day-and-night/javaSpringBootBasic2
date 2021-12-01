package hello.core.autowired;

import hello.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;


//스프링 빈이 없어도 동작해야할 경우가 있다
//@Autowired만 사용하게 될경우 required 옵션 값이 true이기 때문에 자동 주입 대상이 없으면 오류가 발생한다.
//다음은 자동 주입 대상을 옵션으로 처리하는 경우이다
//
public class AutowiredTest {
    @Test
    void AutowiredOption(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);


    }

    static class TestBean{
        //의존관계가 없을 경우 메서드 자체가 호출되지 않는다.
        @Autowired(required = false)
        public void setNoBean1(Member noBean1){
            System.out.println("noBean1 = " + noBean1);
        }
        //의존관계가 없을 때 NULL로 출력
        @Autowired
        public void setNoBean2(@Nullable Member noBean2){
            System.out.println("noBean2 = " + noBean2);
        }

        //의존관계가 없을 때 Optional로 출력
        @Autowired
        public void setNoBean3(Optional<Member> noBean3){
            System.out.println("noBean3 = " + noBean3);
        }
    }
}

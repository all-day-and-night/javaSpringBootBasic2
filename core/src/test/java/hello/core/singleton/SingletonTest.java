/*
스프링은 태생이 기업용 온라인 서비스 기술을 지원하기 위해 탄생했다.
대부분의 스프링 애클리케이션은 웹 애플리케이션이다. 물론 웹이 아닌 애플리케이션 개발도 얼마든지 개발할 수 있다.
웹 애플리케이션은 보통 여러 고객이 동시에 요청한다.
 */

package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SingletonTest {
    @Test
    @DisplayName("스프링이 없는 순수한 DI 컨테이너")
    void pureContainer() {
        AppConfig ac = new AppConfig();
        //1. 조회: 호출할 때 마다 객체를 생성

        MemberService memberService1 = ac.memberService();

        //2. 조회: 호출할 때 마다 객체를 생성
        MemberService memberService2 = ac.memberService();

        //참조값이 다른 것을 확인
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        //객체 타입은 같지만 참조 객체는 다름
        //-> 객체를 계속 생성하는 것은 비효율적임 // 메모리 낭비
        //-> 해당 객체를 1개만 생성하여 공유
        //garbage collector가 있지만 효율성을 고려해야함함
        //memberService1 != memberService2
        Assertions.assertThat(memberService1).isNotSameAs(memberService2);
    }
    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void springContainer(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        //1. 조회: 호출할 때 마다 객체를 생성

        MemberService memberService1 = ac.getBean("memberService", MemberService.class);

        //2. 조회: 호출할 때 마다 객체를 생성
        MemberService memberService2 = ac.getBean("memberService", MemberService.class);

        //참조값이 다른 것을 확인
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        //객체 타입은 같지만 참조 객체는 다름
        //-> 객체를 계속 생성하는 것은 비효율적임 // 메모리 낭비
        //-> 해당 객체를 1개만 생성하여 공유
        //garbage collector가 있지만 효율성을 고려해야함함
        //memberService1 != memberService2
        Assertions.assertThat(memberService1).isSameAs(memberService2);
    }
}


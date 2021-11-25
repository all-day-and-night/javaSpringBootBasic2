package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
@Bean만 사용해도 스프링 빈으로 등록되지만 싱글톤은 보장하지 않는다

Configuration을 사용하게 된다면 스프링에서 자동으로 싱글톤을 보장하여 실행한다.

 */
@Configuration
public class AppConfig {
    //의존관계 주입 -> 리팩토링
    //spring container는 singletone pattern을 자동으로 적용해줌



    @Bean
    public MemberService memberService(){
        //System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemoryMemberRepository memberRepository() {
        //System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService(){
        //System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy(){
        //->할인 정책을 쉽게 교체, 인터페이스를 implements하는 class 구현 후 교체
        //return new FixDiscountPolicy();
        //System.out.println("call AppConfig.discountPolicy");
        return new RateDiscountPolicy();
    }

}

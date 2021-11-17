package hello.core.member;


import hello.core.AppConfig;
import hello.core.order.OrderService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService ;

    //@Test

    @BeforeEach
    void join(){
        /*
        //given
        Member member = new Member(1L, "memberA", Grade.VIP);
        //when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);
        //then
        Assertions.assertThat(member).isEqualTo(findMember);
        */
        // 수정후 ->

        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();


    }

}

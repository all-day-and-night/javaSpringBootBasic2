/*
싱글톤 패턴을 적용한 객체 사용
 */

package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class singletonServiceTest {

    @Test
    @DisplayName("싱글톤 패턴 적용한 객체 사용")
    void singletonPattern(){
        SingletonService singletonService1 = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();

        System.out.println("SingletonService1 = " + singletonService1);
        System.out.println("SingletonService2 = " + singletonService2);
        Assertions.assertThat(singletonService1).isSameAs(singletonService2);

        //같은 singletonService 객체 참조

    }

}

package hello.core.scope;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Provider;

public class PrototypeProviderTest2 {
    @Test
    void providerTest(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ClientBean.class, PrototypeBean.class);

        ClientBean clientBean1 = ac.getBean(ClientBean.class);
        int count1 = clientBean1.logic();
        Assertions.assertThat(count1).isEqualTo(1);

        ClientBean clientBean2 = ac.getBean(ClientBean.class);
        int count2 = clientBean2.logic();
        Assertions.assertThat(count2).isEqualTo(1);
        System.out.println(clientBean1);
        System.out.println(clientBean2);


    }

    @Scope("singleton")
    static class ClientBean{

        /*
        @Autowired
        private ObjectProvider<PrototypeBean> prototypeBeanObjectProvider;


        public int logic(){
            //외부에서 주입받는게 아니라 직접 필요한 의존관계를 찾는 것을 Dependency LooK up 이라고 한다.
            PrototypeBean prototypeBean = prototypeBeanObjectProvider.getObject();
            System.out.println(prototypeBean);
            prototypeBean.addCount();
            int count = prototypeBean.getCount();
            return count;
        }
        */
        @Autowired
        private Provider<PrototypeBean> prototypeBeanProvider;

        public int logic(){
            PrototypeBean prototypeBean = prototypeBeanProvider.get();
            prototypeBean.addCount();
            int count = prototypeBean.getCount();
            return count;
        }
    }

    @Scope("prototype")
    static class PrototypeBean{
        private int count = 0;

        public void addCount(){
            count++;
        }

        public int getCount(){
            return count;
        }

        @PostConstruct
        public void init(){
            System.out.println("Prototype.init " + this);
        }

        @PreDestroy
        public void destroy(){
            System.out.println("Prototype.destroy");
        }
    }
}

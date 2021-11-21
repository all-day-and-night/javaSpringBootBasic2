/*
싱글톤 패턴
-클래스의 인스턴스가 딱 1개만 생성되는 것을 보장하는 디자인 패턴
-두 개 이상의 객체 인스턴스 생성 방지
 -private 생성자를 사용해서 외부에서 임의로 new 키워드를 사용하지 못하도록 막아야 한다.
 */

package hello.core.singleton;

public class SingletonService {
    //단 하나만 생성
    public static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance(){
        return instance;
    }

    //private 생성자로 외부에서 new 로 생성하는 것 지양
    private SingletonService(){

    }

    public void login(){
        System.out.println("싱글톤 객체 로직 호출");
    }

}

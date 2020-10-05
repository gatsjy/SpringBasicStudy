package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * @author Gatsjy
 * @since 2020-10-05
 * realize dreams myself
 */
public class SingletonTest {
    
    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    void pureContainer(){
        AppConfig appConfig = new AppConfig();
        // 1. 조회 : 호출할 때 마다 객체를 생성
        MemberService memberService1 = appConfig.memberService();

        // 2. 조회 : 호출할 때 마다 객체를 생성
        MemberService memberService2 = appConfig.memberService();
        
        // 참조 값이 다른 것을 확인 -> 서로 다른 객체가 생성하는 것을 볼 수 있다.
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        // memberService1 != memberService2
        assertThat(memberService1).isNotSameAs(memberService2);

        // 그렇다면? 해당 객체가 한번만 생성되고 그것을 공유할 수 있으면 객체를 계속 생성하지 않고 효율적으로 사용할 수 있지 않을까?
        // 싱글톤 패턴이란? 클래스의 인스턴스가 딱 1개만 생성되는 것을 보장하는 디자인 패턴이다.
        // 그래서 객체 인스턴스를 2개이상 생성하지 못하도록 막아야 한다.
    }
    
    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    void singletonServiceTest(){
        //다음과 같이 new 객체로 생성하려고 하면 생성되지 않는다.
        //new SingletonService();
        SingletonService singletonService1 = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();

        // 같은 객체 인스턴스가 반환됩니다.
        // 생성하는데 드는 비용이 절약됩니다.
        System.out.println("singletonService1 = " + singletonService1);
        System.out.println("singletonService2 = " + singletonService2);

        //assertThat(singletonService1).isEqualTo(singletonService2);
        assertThat(singletonService1).isSameAs(singletonService2);

        // 싱글톤 패턴의 문제점
        // - 싱글톤 패턴 구현하는 코드 자체의 코드가 들어간다.
        // - 의존관계상 클라이언트가 구체 클래스에 의존한다. (getInstance())
        // - 테스트하기 어렵다.
        // - 내부 속성을 변경하거나 초기화 하기 어렵다.
        // - private 생성자로 자식 클래스를 만들기 어렵다.
    }
}

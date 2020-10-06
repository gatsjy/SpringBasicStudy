package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 구성정보
// 코드가 약간 더 복잡해진 것 같은데, 스프링 컨테이너를 사용하면 어떤 장점이 있을까? -> 2020-10-04 물음..
// -> 결론적으로는 어마어마한 장점이 있다고 한다. 근데 아직까지는 맘에 와닿지 않음.. (범용의 프레임워크가 생겼다고.. 생각하자)
@Configuration // 여기에 싱글톤의 비밀이 있다. -> @Configuration을 빼면 순수한 AppConfig를 가져와서 쓴다.
public class AppConfig {
    // AppConfig를 통해서 관심사를 확실하게 분리했다.
    // 배역, 배우를 생각해보자. AppConfig는 공연 기획자이다.
    // AppConfig는 구체 클래스를 선택한다. 배역에 맞는 배우를 생성한다.

    // @Bean memberService -> new MemoryMemberRepository()
    // @Bean orderService -> new MemoryMemberRepository()
    // 이러면 싱글톤이 깨질까?

    @Bean
    public MemberService memberService(){
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    // 생성자를 통해서 주입
    @Bean
    public OrderService orderService(){
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public MemberRepository memberRepository(){
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy(){
        //return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}

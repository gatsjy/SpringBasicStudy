package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;

public class OrderServiceImpl implements OrderService {

    // private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    // private final DiscountPolicy discountPolicy = new RateDiscountPolicy(); // 실제 소스 코드를 바꿔야 한다.
    // 역할과 구현을 철저히 분리하긴 하였다 하지만..
    // 다형성도 활용하고, 인터페이스와 구현 객체를 분리했다.
    // OCP, DIP 같은 객체지향 설계 원칙을 충분히 준수했는가? -> 추상에도 의존하고 있고 구체에서도 의존하고 있다.

    // 인터페이스에만 의존하도록 코드를 변경하였다.
    // "누군가" 대신 이 인터페이스를 구체화 시켜줘야한다...
    // private DiscountPolicy discountPolicy = new FixDiscountPolicy(); // -> 구체적인 것 까지 선택해서는 안되는 것이다. (마치 배우가 배우까지 선택하는 꼴..)
    // 애플리케이션의 전체 동작 방식을 구성하는 구현객체를 생성해서 해결해야 한다.
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy; // -> 구체적인 것 까지 선택해서는 안되는 것이다.

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {

        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}

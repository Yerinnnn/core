package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.*;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

// AppConfig의 등장으로, 애플리케이션이 사용 영역과, 객체를 생성하고 구성하는 영역으로 분리됨
// 그렇기 때문에 구성 영역(AppConfig)만 수정하면 되고, 사용 영역은 전혀 손 댈 필요가 없음
public class AppConfig {
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    private static MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy() {
        // 클라이언트 코드를 전혀 수정하지 않고도 애플리케이션의 기능을 확장할 수 있음
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
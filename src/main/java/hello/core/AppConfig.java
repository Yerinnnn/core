package hello.core;

import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

// 의존성 주입 컨테이너의 역할을 수행
// 애플리케이션의 실제 동작에 필요한 구현 객체를 모두 생성함
// (MemberServiceImpl, MemoryMemberRepository, OrderServiceImpl, FixDiscountPolicy)
// 생성한 객체 인스턴스의 참조(레퍼런스)를 생성자를 통해서 주입(연결)해줌 : 생성자 주입

// `appConfig` 객체는 `memoryMemberRepository` 객체를 생성하고 그 참조값을 `memberServiceImpl` 을 생성하면서 생성자로 전달함
// 클라이언트인 `memberServiceImpl` 입장에서 보면 의존관계를 마치 외부에서 주입해주는 것 같다고 해서
// DI(Dependency Injection), 우리말로 의존관계 주입 또는 의존성 주입이라 함
public class AppConfig {
    // MemberService를 반환하는 memberService 메소드
    // 구현체로 MemberServiceImpl를 반환
    // MemberServiceImpl 객체를 생성하면서, 생성자를 통해 MemoryMemberRepository의 인스턴스를 의존성으로 주입
    // MemberServiceImpl이 MemberRepository에 대한 의존성을 외부로부터 주입받아 결합도를 낮추고, 유연성 및 테스트 용이성을 향상시킴
    // 생성자를 통해서 객체가 new 인스턴스 생성된 게 들어간다고 해서, 생성자 주입이라고 함
    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    // 누군가 AppConfig를 통해서 orderService를 조회하면, OrderServiceImpl이 반환이 되는, 거기에 2개의 인스턴스가 들어감
    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}
package hello.core.order;

import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class OrderServiceImplTest {
    // 수정자 의존관계로 테스트할 경우,
    // NullPointerException 발생
    // createOrder()만 테스트하고 싶어도, createOrder()에 가보면
    // memberRepository와 discountPolicy가 필요함
    // 그러면 가짜 memoryRepository라도 만들어서 넣어줘야 함

    // 생성자 의존관계로 테스트할 경우,
    // 컴파일 오류 발생
    // new OrderServiceImpl()을 만드는 순간
    // memberRepository와 discountPolicy가 필요하지라고 바로 인식할 수 있음
    // 테스트니까 임의로 new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy()) 등으로 넣고 테스트 하면 됨
    // + memberRepository가 null 이라는 에러가 발생해서 28, 29라인 추가해줌
    @Test
    void createOrder() {
        MemoryMemberRepository memberRepository = new MemoryMemberRepository();
        memberRepository.save(new Member(1L, "name", Grade.VIP));

        OrderServiceImpl orderService = new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
        Order order = orderService.createOrder(1L, "itemA", 10000);

        assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberRepository;
import hello.core.member.MemberServiceImpl;
import hello.core.order.OrderServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import
        org.springframework.context.annotation.AnnotationConfigApplicationContext;
import static org.assertj.core.api.Assertions.*;

public class ConfigurationSingletonTest {
    @Test
    void configurationTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
        MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);

        //모 두 같은 인스턴스를 참고하고 있음
        System.out.println("memberService -> memberRepository = " + memberService.getMemberRepository());
        System.out.println("orderService -> memberRepository  = " + orderService.getMemberRepository());
        System.out.println("memberRepository = " + memberRepository);

        // 모두 같은 인스턴스를 참고하고 있음
        assertThat(memberService.getMemberRepository()).isSameAs(memberRepository);
        assertThat(orderService.getMemberRepository()).isSameAs(memberRepository);
    }

    @Test
    void configurationDeep() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        // AppConfig도 스프링 빈으로 등록됨
        AppConfig bean = ac.getBean(AppConfig.class);
        // getClass : 타입을 보는 것
        System.out.println("bean = " + bean.getClass());
        // 출력: bean = class hello.core.AppConfig$$SpringCGLIB$$0 }
        // 순수한 class라면 class hello.core.AppConfig라고 출력되어야 함
        // CGLIB : 바이트코드 조작 라이브러리
        // AppConfig@CGLIB라는 조작한 클래스를 스프링빈으로 등록해버림
    }
}

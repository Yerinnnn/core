package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();

        // Spring은 모든 게 ApplicationContext에서 시작됨
        // 이게 Spring Container라고 보면 됨
        // AppConfig에 있는 환경설정 정보를 가지고 Spring이 Spring Container에 생성한 객체들(@Bean들)을 집어넣고 관리해줌
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        // 원래는 AppConfig appConfig에서 직접 찾아왔는데, 이제는 Spring Container에서 찾아와야 함
        // 첫 번째 : 찾을 객체 이름, 두 번째 : 반환 타입
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("find Member = " + findMember);
        System.out.println("new Member = " + member);
    }
}

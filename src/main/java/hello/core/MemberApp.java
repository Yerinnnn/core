package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        // 기존에는 MemberServiceImpl을 직접 main 메소드에서 생성하고,
        // MemberServiceImpl에서도 직접 MemoryMemberRepository를 생성했었음
        // 이제는 appConfig에서 모두 결정함
        MemberService memberService = appConfig.memberService();
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("find Member = " + findMember);
        System.out.println("new Member = " + member);
    }
}

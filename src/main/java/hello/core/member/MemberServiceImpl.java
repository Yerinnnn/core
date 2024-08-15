package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;

    // MemberServiceImpl을 생성하면서, 스프링이 스프링 컨테이너에 있는 MemberRepository를 뒤져봄(타입으로 조회함)
    // 그래서, memoryMemberRepository를 찾아서 주입해줄 수 있음
    // (memoryMemberRepository는 memberRepository의 자식이니까 타입이 맞기 때문에)
    // 같은 타입이 여러개면 충돌 발생
    @Autowired  // ac.getBean(MemberRepository.class)와 동일한 기능
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}

package hello.core.member;

public class MemberServiceImpl implements MemberService {

    // 인터페이스 가져올 때는 구현체 선택 필수로 해줘야 함
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public void join(Member member) {
        // 다형성에 의해서 MemberRepository 인터페이스가 아니라, MemoryMemberRepository에 있는 save()가 호출됨
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}

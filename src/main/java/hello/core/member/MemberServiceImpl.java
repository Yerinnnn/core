package hello.core.member;

public class MemberServiceImpl implements MemberService {

    // 이제, DIP 완성 : DIP를 지키고 추상화에만 의존하도록 수정됨
    // 관심사의 분리 : 객체를 생성하고 연결하는 역할과 실행하는 역할이 명확히 분리됨
    // MemberRepository 인터페이스에만 의존함
    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

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

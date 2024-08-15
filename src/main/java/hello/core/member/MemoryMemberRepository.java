package hello.core.member;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component  // 컴포넌트 어노테이션 붙으면, 자동으로 빈 이름이 memoryMemberRepository로 설정됨
public class MemoryMemberRepository implements MemberRepository {

    // 원래는 동시성 이슈가 있기 때문에,ConcurrentHashMap을 사용해야하는데, 그냥 예제니까 HashMap 사용!
    private static Map<Long, Member> store = new HashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}

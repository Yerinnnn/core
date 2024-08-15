package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        basePackages = "hello.core",
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {
    // 수동 빈 등록 vs 자동 빈 등록
    // 이 경우 수동 빈 등록이 우선권을 가짐 (수동 빈이 자동 빈을 오버라이딩 함)
    // 우린 우리가 만든 테스트로 돌려서, 자동으로 수동 빈이 우선권을 가진 것으로 실행 되었지만,
    // 최근 스프링 부트에서는 수동 빈 등록과 자동 빈 등록이 충돌나면 오류가 발생하도록 기본 값이 바뀌었기 때문에,
    // 스프링 부트로 돌리면 (CoreApplication에서 Run), 오류가 발생함
    // 오버라이딩 하게 하고 싶으면 설정을 setting spring.main.allow-bean-definition-overriding=true 로 바꾸라는 메세지가 함께 출력됨
    // 그 설정을 applictaion.properties에 복붙하면 됨
    @Bean(name = "memoryMemberRepository")
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}

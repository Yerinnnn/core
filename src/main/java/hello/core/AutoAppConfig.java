package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        // 탐색 시작 위치 설정 (여러 개 설정 가능)
        // 지정하지 않으면 `@ComponentScan` 이 붙은 설정 정보 클래스의 패키지가 시작 위치가 됨
        // 권장 : 패키지 위치를 지정하지 않고, 설정 정보 클래스의 위치를 프로젝트 최상단에 두는 것
        // `com.hello` 프로젝트 시작 루트, 여기에 AppConfig 같은 메인 설정 정보를 두고,
        // @ComponentScan 애노테이 션을 붙이고, `basePackages` 지정은 생략하면 됨
        // 스프링 부트를 사용하면 스프링 부트의 대표 시작 정보인 `@SpringBootApplication` 를 이 프로젝트 시작 루트 위치에 두는 것이 관례
        // (이 설정안에 `@ComponentScan` 이 들어있음 !)
        basePackages = "hello.core",
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {
}

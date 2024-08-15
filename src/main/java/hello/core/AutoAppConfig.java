package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(  // @Component 어노테이션이 붙은 클래스를 찾아서 자동으로 스프링 빈으로 등록해줌
        // 제외할 클래스들의 필터를 만들어줌
        // @Configuration 어노테이션 코드를 보면 @Component가 붙어있기 때문에, 자동 스캔의 대상이 됨
        // AppConfig.class 같은 건 수동으로 등록하는 파일이기 때문에, 자동 스캔되면 충돌이 나서 제외해줌
        // (일반적으로 Configuration 어노테이션이 붙은 클래스를 제외하지는 않음)
        // (여기서는 예제 코드가 남아있기 떄문에 제외함)
        // Configuration FilterType.ANNOTATION이 붙은 건 제외한다는 뜻
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {
}

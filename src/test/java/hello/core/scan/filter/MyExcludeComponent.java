package hello.core.scan.filter;

import java.lang.annotation.*;

@Target(ElementType.TYPE)  // TYPE : 타겟이 클래스 (클래스 레벨에 붙인다는 뜻)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyExcludeComponent {
}

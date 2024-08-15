package hello.core.annotation;

import org.springframework.beans.factory.annotation.Qualifier;
import java.lang.annotation.*;

// MainDiscountPolicy을 사용하면 이 기능들이 모두 동작함
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER,
        ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Qualifier("mainDiscountPolicy")
public @interface MainDiscountPolicy {
}

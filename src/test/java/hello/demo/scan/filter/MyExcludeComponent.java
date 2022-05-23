package hello.demo.scan.filter;

import java.lang.annotation.*;

@Target(ElementType.TYPE) // 클래스 레벨 대상
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyExcludeComponent {
}

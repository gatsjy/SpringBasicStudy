package hello.core.scan.filter;

import java.lang.annotation.*;

/**
 * @author Gatsjy
 * @since 2020-10-06
 * realize dreams myself
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyIncludeComponent {
}

package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 * @author Gatsjy
 * @since 2020-10-06
 * realize dreams myself
 */
@Configuration
@ComponentScan(
        basePackages = "hello.core.member",
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class) // 실제 현업에서는 다음 기능을 쓰지 않지만 예제 코드를 최대한 보존하기 위해 다음과 같은 조치를 취함.
)// 자동으로 스프링 빈을 긁어오는 기능

// 근데 여기는 아무런 것도 없다.
public class AutoAppConfig {
}




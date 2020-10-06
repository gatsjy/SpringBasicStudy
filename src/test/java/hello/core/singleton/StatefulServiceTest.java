package hello.core.singleton;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Gatsjy
 * @since 2020-10-05
 * realize dreams myself
 */
class StatefulServiceTest {

    @Test
    void statefulServiceSingleton(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        //ThreadA : A사용자가 10000원 주문
        //statefulService1.order("userA", 10000);
        int userAPrice = statefulService1.order("userA", 10000);
        //ThreadB : B사용자가 20000원 주문
        //statefulService2.order("userB", 20000);
        int userBPrice = statefulService2.order("userB", 20000);

        //ThreadA : 사용자A 주문 금액 조호;
        int price = statefulService1.getPrice();

        // 기대한 값은 10000인데.. 나오는 값은 userB의 20000이 나온다
        System.out.println(price);
        System.out.println(userAPrice);

        org.assertj.core.api.Assertions.assertThat(statefulService1.getPrice()).isEqualTo(0);
        org.assertj.core.api.Assertions.assertThat(userBPrice).isEqualTo(20000);

    }

    static class TestConfig{

        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }
    }
}
package hello.core;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Gatsjy
 * @since 2020-10-07
 * realize dreams myself
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
public class HelloLombok {

    private String name;
    private int age;

    public static void main(String[] args) {
        HelloLombok helloLombok = new HelloLombok();
        helloLombok.setName("123123");
        System.out.println("helloLombok = " + helloLombok);
    }
}

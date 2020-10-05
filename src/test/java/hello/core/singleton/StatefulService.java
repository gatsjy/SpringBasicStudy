package hello.core.singleton;

/**
 * @author Gatsjy
 * @since 2020-10-05
 * realize dreams myself
 */
public class StatefulService {
    
    private int price; //상태를 유지하는 필드

/*    public void order(String name, int price){
        System.out.println("name = " + name + " price = " + price);
        this.price = price; // 여기가 문제
        // 진짜 공유필드는 조심해야한다. 스프링 빈든 항상 무상태(statelsee)로 설계하자.
    }*/
    
    // 무상태로 개발하기
    public int order(String name, int price){
        System.out.println("name = " + name + " price = " + price);
        return price;
    }

    public int getPrice(){
        return price;
    }
}

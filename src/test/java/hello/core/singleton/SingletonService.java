package hello.core.singleton;

/**
 * @author Gatsjy
 * @since 2020-10-05
 * realize dreams myself
 */
public class SingletonService {

    // 딱 하나만 존재하게 된다.
    // 1. static 영역에 객체를 딱 1개만 생성해둔다.
    private static final SingletonService instance = new SingletonService();

    // 2. public으로 열어서 객체 인스턴스가 필요하다면 이 static메서드를 통해서만 조회하도록 한다.
    public static SingletonService getInstance(){
        return instance;
    }

    // 자기만 생성하도록 생성자를 private로 만든다.
    // 3. 생성자를 private로 선언해서 외부에서 new 키워드를 사용한 객체 생성을 못하게 막는다.
    // 3-1. 생성자를 private으로 막아서 혹시라도 외부에서 new 키워드로 객체 인스턴스가 생성되는 것을 막는다.
    private SingletonService(){
    }
    
    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }
}

package hello.core.lifecycle;

/**
 * @author Gatsjy
 * @since 2020-10-10
 * realize dreams myself
 */
// 스프링 컨테이너 생성 -> 스프링 빈 생성 -> 의존관계 주입 -> 초기화 콜백 -> 사용 -> 소멸전 콜백 -> 스프링 종료
// 참고 : 객체의 생성과 초기화를 분리하자
// 생성자는 필수 정보(파라미터)를 받고, 메모리에 살항해서 객체를 생성하는 책임을 가진다. 반면에 초기화는 이렇게 생성된 값들을 활용해서 외부 커넥션을 연결하는등 무거운 동작을 수행한다.
// 따라서 생성자 안에서 무거운 초기화 작업을 하는 것보다는 객체를 생성하는 부분과 초기화 하는 부분을 명확하게 나누는 것이 유지보수 관점에서 더 좋다.
// 물론 초기화 작업이 내부 값들만 약간 변경하는 정도로 단순한 경우에는 생성자에서 한번에 다 처리하는게 더 나을 수 있다.
public class NetworkClient {

    private String url;

    public NetworkClient(){
        System.out.println("생성자 호출, url = " + url);
//        connect();
//        call("초기화 연결 메세지");
    }

    public void setUrl(String url){
        this.url = url;
    }

    // 서비스 시작시 호출
    public void connect(){
        System.out.println("connect : " + url);
    }
    
    public void call(String message){
        System.out.println("call : " + url + " message = " + message);
    }
    
    // 서비스 종료시 호출
    public void disconnect(){
        System.out.println("close : " + url);
    }

    // 의존관계 주입이 끝나면 호출하도록 하겠다.
    // 이는 스프링에 의존적으로 써야 한다.
    public void init() {
        System.out.println("NetworkClient.init");
        connect();
        call("초기화 연결 메세지");
    }

    // 빈이 종료될때 호출된다.
    // 추론해서 close나 shutdown이라는 이름의 메서드가 있으면 자동으로 호출해준다.
    public void close() {
        System.out.println("NetworkClient.close");
        disconnect();
    }
}

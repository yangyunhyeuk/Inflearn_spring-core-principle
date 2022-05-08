package hello.demo.singleton;

public class SingletonService {

    // 1. static 영역에 객체를 1개만 생성한다.
    private static final SingletonService instance = new SingletonService();

    // 2. public 으로 열어서 객체 인스턴스가 필요하면 이 static 메서드를 통해 조회하도록 허용한다.
    public static SingletonService getInstance() {
        return instance;
    }
    // 3. 생성자를 private 으로 선언하여 외부에서 new 키워드를 사용한 객체 생성을 막는다.
    // 다음의 메서드가 없을 경우 다른 파일에서 해당 클래스 객체를 생성할 수 있다.
    private SingletonService() {

    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }

}

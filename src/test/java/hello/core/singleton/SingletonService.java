package hello.core.singleton;

public class SingletonService {
    // 1. static으로 설정하여 static 영역에 객체를 딱 1개만 생성함
    // 자바가 실행될 때, static 영역에 1개가 만들어짐
    private static final SingletonService instance = new SingletonService();
    // 2. public으로 열어서, 외부에서 객체 인스턴스가 필요하면 이 static 메서드를 통해서만 조회하도록 허용함
    // 인스턴스에 참조할 수 있는 방법은 getInstance() 메소드 밖에 없도록 함
    public static SingletonService getInstance() {
        return instance;
    }
    // 3. 생성자를 private으로 선언해서 외부에서 new 키워드를 사용한 객체 생성을 못하게 막음
    private SingletonService() {
    }
    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}

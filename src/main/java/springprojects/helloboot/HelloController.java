package springprojects.helloboot;

import java.util.Objects;

public class HelloController {
    private final HelloService helloService;

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    public String hello(String name) {
        return helloService.sayHello(Objects.requireNonNull(name)); // null인지 체크함 null이라면 예외를 던지고, null이 아니라면 값을 그대로 리턴
    }
}

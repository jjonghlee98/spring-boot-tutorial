package springprojects.helloboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Objects;

@RequestMapping("/hello")
public class HelloController {
    private final HelloService helloService;

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping
    @ResponseBody // responseBody를 사용하지 않으면 view라고 불리는 템플릿을 찾기 때문에 찾을 수 없다. (404)
    public String hello(String name) {
        return helloService.sayHello(Objects.requireNonNull(name)); // null인지 체크함 null이라면 예외를 던지고, null이 아니라면 값을 그대로 리턴
    }
}

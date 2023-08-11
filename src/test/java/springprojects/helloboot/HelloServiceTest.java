package springprojects.helloboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

//@Retention(RetentionPolicy.RUNTIME)
//@Target(ElementType.METHOD)
//@UnitTest
//@interface FastUnitTest {
//}
//
//@Retention(RetentionPolicy.RUNTIME)
//@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD})
//@Test
//@interface UnitTest {
//}

public class HelloServiceTest {
    @Test
    void simpleHelloService() {
        HelloService helloService = new SimpleHelloService();

        String ret = helloService.sayHello("Test");

        Assertions.assertThat(ret).isEqualTo("Hello Test");
    }

    @Test
    void helloDecorator() {
        HelloDecorator decorator = new HelloDecorator(name -> name);

        String ret = decorator.sayHello("Test");

        Assertions.assertThat(ret).isEqualTo("*Test*");
    }
}

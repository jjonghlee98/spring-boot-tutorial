package springprojects.helloboot;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class HellobootApplication {

	public static void main(String[] args) {
		// dispatcherServlet을 사용할 때는 GenericApplicationContext가 아닌 GenericWebApplicationContext를 사용한다.
		GenericWebApplicationContext applicationContext = new GenericWebApplicationContext();
		applicationContext.registerBean(HelloController.class);
		applicationContext.registerBean(SimpleHelloService.class);
		applicationContext.refresh();

		ServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
		WebServer webServer = serverFactory.getWebServer(servletContext -> {
			// dispatcherServlet은 WebApplicationContext 타입을 사용해야 한다.
			// dispatcherServlet에 applicationContext를 넘겨서 매핑을 하다가 작업을 위임할(요청을 Dispatch할) 오브젝트를 찾아야 하는데
			// 그 때 사용할 서블릿 컨테이너를 전달해줌.
			servletContext.addServlet("dispatcherServlet",
					new DispatcherServlet(applicationContext))
					.addMapping("/*");
		});
		webServer.start();
	}

}

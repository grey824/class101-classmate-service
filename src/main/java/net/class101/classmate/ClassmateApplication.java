package net.class101.classmate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ClassmateApplication {

	public static void main(String[] args) {
		final SpringApplication application = new SpringApplication(ClassmateApplication.class);
		application.setWebApplicationType(WebApplicationType.SERVLET);

		final ConfigurableApplicationContext ctx = application.run(args);
		final String serverPort = ctx.getEnvironment().getProperty("server.port");
		final String profile = ctx.getEnvironment().getProperty("spring.profiles.active");

		// startup notification
		final String banner = "ClassmateApplication started (profile=" + profile + ", port=" + serverPort + ")";
		System.out.println(banner);
	}
}

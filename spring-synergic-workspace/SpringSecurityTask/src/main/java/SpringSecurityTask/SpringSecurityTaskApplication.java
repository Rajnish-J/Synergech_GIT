package SpringSecurityTask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringSecurityTaskApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SpringSecurityTaskApplication.class, args);

		System.out.println("Project Started....");

	}

}

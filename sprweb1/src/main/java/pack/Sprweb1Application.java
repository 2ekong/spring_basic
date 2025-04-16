package pack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Sprweb1Application {

	public static void main(String[] args) {
		//SpringApplication.run(Sprweb1Application.class, args);
		SpringApplication.run(Sprweb1Application.class, args).getBean(Sprweb1Application.class).execute();
	}
	
	@Autowired
	private My my;
	
	private void execute() {
		System.out.println("독립적인 응용 프로그램 작성 가능");
		my.kbs();
		
	}
}

package pack.business;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Configuration
@ComponentScan(basePackages = "pack")
public class Main {
	public static void main(String[] args) { // Main이 환경을 잡아주는 역할도 할 수 있다.
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
		
		BusinessInter inter = (BusinessInter)context.getBean("businessImpl");
		inter.dataList();
	}
}
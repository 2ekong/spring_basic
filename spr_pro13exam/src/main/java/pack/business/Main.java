package pack.business;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "pack")
@MapperScan(basePackages = "pack.model")
public class Main {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
		BusinessInter inter = (BusinessInter) context.getBean("businessImpl");

		inter.dataPrint();
		((BusinessImpl) inter).printDeptInfo();
	}
}

package pack;

import java.util.Scanner;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Loginadvice {

	@Around("execution(public void startProcess())")
	public Object mymethod(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("id 입력: ");
		Scanner scanner = new Scanner(System.in);
		String id = scanner.nextLine();
		scanner.close();
		if(!id.equals("aa")) {
			System.out.println("id 불일치 작업을 종료합니다.");
			return null;
		}
		
		Object object = joinPoint.proceed();
		
		return object;
	}
}

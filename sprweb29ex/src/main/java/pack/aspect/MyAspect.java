package pack.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
@Aspect
public class MyAspect {

    @Autowired
    private LoginClass loginClass;

    @Around("execution(* *..*Controller.*Process(..))")
    public Object aopProcess(ProceedingJoinPoint joinPoint) throws Throwable {
        HttpServletRequest request = null;
        HttpServletResponse response = null;
        
        // 인자에서 HttpServletRequest, HttpServletResponse 찾기
        for (Object arg : joinPoint.getArgs()) {
            if (arg instanceof HttpServletRequest) {
                request = (HttpServletRequest) arg;
            } else if (arg instanceof HttpServletResponse) {
                response = (HttpServletResponse) arg;
            }
        }

        // 만약 request나 response가 여전히 null이면 예외 처리
        if (request == null || response == null) {
            throw new IllegalArgumentException("Request or Response object is missing in the method signature.");
        }

        // 로그인 체크
        if (loginClass.LoginCheck(request, response)) {
            // 로그인 실패 시
            return null;
        }

        // 실제 핵심 로직 실행
        return joinPoint.proceed();
    }
}

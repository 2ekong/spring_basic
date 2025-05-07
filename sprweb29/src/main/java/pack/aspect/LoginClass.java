package pack.aspect;

import org.springframework.stereotype.Component;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Component
public class LoginClass {	//로그인이 관심 사항
	public boolean LoginCheck(HttpServletRequest request, HttpServletResponse response) throws Exception{
		HttpSession httpSession = request.getSession();	//웹 서버가 저장새 둔 쿠키값(세션) 읽기
		if(httpSession.getAttribute("nameok") == null) {
			response.sendRedirect("login");	//LoginController 와 매핑
			return true;
		}else {
			return false;
		}
	}
}

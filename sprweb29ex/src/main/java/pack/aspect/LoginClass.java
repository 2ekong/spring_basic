package pack.aspect;

import org.springframework.stereotype.Component;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Component
public class LoginClass {	//로그인이 관심 사항
	public boolean LoginCheck(HttpServletRequest request, HttpServletResponse response) throws Exception {
	    if (request == null || response == null) {
	        throw new IllegalArgumentException("Request or Response object is missing.");
	    }

	    HttpSession httpSession = request.getSession();
	    if (httpSession.getAttribute("gogekok") == null) {
	        response.sendRedirect("login");
	        return true;
	    }
	    return false;
	}

}

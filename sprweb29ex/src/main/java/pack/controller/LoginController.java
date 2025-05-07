package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pack.model.DataDao;
import pack.model.Gogek;

@Controller
public class LoginController {

    @Autowired
    private DataDao dataDao;
    
    // 로그인 페이지 렌더링 (GET)
    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }

    // 로그인 처리 (GET)
    @GetMapping("/loginaction")
    public String getLogin(HttpServletRequest request, HttpServletResponse response, 
                           @RequestParam("no") String no, 
                           @RequestParam("name") String name) {
        try {
            int gogekno = Integer.parseInt(no.trim());
            Gogek gogek = dataDao.gogekLogin(gogekno, name.trim());
            
            if (gogek != null) {
                request.getSession().setAttribute("gogekok", gogekno);
                return "redirect:/jikwonlist";
            }
        } catch (NumberFormatException e) {
            // 잘못된 번호 형식 처리
            return "login";
        }

        return "login";  // 로그인 실패 시 다시 로그인 페이지로
    }

    // 로그아웃 처리
    @GetMapping("/logout")
    public String getLogoutProcess(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().removeAttribute("gogekok");
        return "redirect:/";
    }
}

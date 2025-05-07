package pack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pack.model.DataDao;
import pack.model.Jikwon;

@Controller
public class Jikwoncontroller {
	
	@Autowired
	private DataDao dataDao;
	
	@GetMapping("jikwonlist")
	//AOP 로그인 처리시 pointcut 대상 메소드는 request, response가 있어야 함
	public String jikwonProcess(HttpServletRequest request, HttpServletResponse response, Model model) {
		List<Jikwon> jlist = dataDao.jikwonListAll();
		model.addAttribute("jlist",jlist);
		return "jikshow";
	}
	
	
}

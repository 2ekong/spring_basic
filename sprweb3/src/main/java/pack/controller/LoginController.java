package pack.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	@GetMapping("login")
	public String goLogin() {
		return "redirect:http://localhost/login.html";
	}
	
	@PostMapping("login")
	public String check(@RequestParam("id")String id, @RequestParam("pwd")String pwd,Model model) {
		String data = "";
		if(id.equals("aa") && pwd.equals("11")) {
			return "redirect:http://localhost/input.html";
		}else {
			model.addAttribute("data", "로그인 실패");
	        return "display"; 
		}
		
	}
}

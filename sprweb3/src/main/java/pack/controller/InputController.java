package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import pack.model.ScoreModel;

@Controller
public class InputController {
	@Autowired
	private ScoreModel scoreModel;
	
	@GetMapping("input")
	public String aaa() {
		return "redirect:http://localhost/input.html";
	}
	
	@PostMapping("input")
	public String bbb(InputBean bean, Model model) {
		model.addAttribute("data", scoreModel.Result(bean));
		return "display";
	}
}

package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pack.model.JikwonService;

@Controller
public class JikwonController {
	private JikwonService jikwonService;
	
	@Autowired
	public JikwonController(JikwonService jikwonService) {
		this.jikwonService = jikwonService;
	}
	
	@GetMapping("/jikwonlist1")
	public String listJikwon(Model model) {
		model.addAttribute("jikwons", jikwonService.getJikwonDatas());
		return "jikwonlist";
	}
	
	@GetMapping("/jikwonlist2")
	public String listJikwon2(Model model) {
		model.addAttribute("jikwons", jikwonService.getJikwonHighPay());
		return "jikwonlist";
	}
	
	@GetMapping("/jikwonlist3")
	public String listJikwon2(Model model, @RequestParam("busername")String busername) {
		model.addAttribute("jikwons", jikwonService.getAllBuserName(busername));
		return "jikwonlist";
	}
	
	@GetMapping("/jikwonlist4")
	public String listJikwon4(Model model) {
		model.addAttribute("jikwons", jikwonService.getTopPaidJikwon());
		return "jikwonlist";
	}
}

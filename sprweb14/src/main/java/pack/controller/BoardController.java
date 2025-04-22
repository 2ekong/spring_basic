package pack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pack.model.DataDto;
import pack.model.DataProcess;

@Controller
public class BoardController {
	
	@Autowired
	private DataProcess dataProcess;
	
	@GetMapping("/list")
	public String list (Model model) {
		List<DataDto> list = dataProcess.selectAll();
		model.addAttribute("list", list);
		return "list";
	}
	
	@GetMapping("/insert")
	public String insertForm() {
		return "insert";
	}
	
	@PostMapping("/insert")
	public String insertSubmit(@ModelAttribute DataDto dto) {
		dataProcess.insert(dto);
		return "redirect:/list";
	}
	
	@GetMapping("/view")
	public String view(@RequestParam("num") int num, Model model) {
		DataDto dto = dataProcess.selectByNum(num);
		model.addAttribute("dto", dto);
		return "view";
	}
	
	@GetMapping("/update")
	public String updateForm(@RequestParam("num")int num, Model model) {
		DataDto dto = dataProcess.selectByNum(num);
		model.addAttribute("dto", dto);
		return "update";
	}
	
	@PostMapping("/update")
	public String updateSubmit(@ModelAttribute DataDto dto) {
		dataProcess.update(dto);
		return "redirect:/view?num="+dto.getNum();
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("num")int num, Model model) {
		dataProcess.delete(num);
		return "redirect:/list";
	}
	
}

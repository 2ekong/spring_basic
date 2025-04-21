package pack.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pack.model.DataProcess;
import pack.model.MemDto;

@Controller
public class MemController {
	//모델 클래스를 포함관계로 기술
	@Autowired
	private DataProcess dataProcess;
	
	@GetMapping("memlist")
	public String listProcess(Model model) {
		ArrayList<MemDto> list = (ArrayList<MemDto>)dataProcess.getDataAll();
		model.addAttribute("datas",list);
		return "list";
	}
	
	@GetMapping("insert")
	public String insert() {
		return "insert";
	}
	
	@PostMapping("insert")
	public String insertMem(MemBean bean) {
		boolean b = dataProcess.insert(bean);
		if(b)
			//return "list"가 아닌 이유
			//list 는 view name이고 memlist는 url 경로
			//redirect:/memlist는 URL 경로인 /memlist로 리다이렉트하여
			// URL 경로(/memlist)는 MemController의 listProcess 메서드에서 처리되어, 
			//데이터가 반영된 list.html을 다시 보여준다는 의미
			
			
			return "redirect:http://localhost/memlist";
		else
			return "redirect:http://localhost/err.html";
	}
	
	@GetMapping("update")
	public String uodate(@RequestParam("num")String num, Model model) {
		MemDto memDto = dataProcess.getData(num);
		model.addAttribute("data", memDto);
		return "update";
	}
	
	@PostMapping("update")
	public String updateMem(MemBean bean) {
		boolean b = dataProcess.update(bean);
		if(b)
			return "redirect:/memlist";
		else
			return "redirect:/err.html";
	}
	
	@GetMapping("delete")
	public String deleteMem(@RequestParam("num")String num) {
		boolean b = dataProcess.delete(num);
		if(b)
			return "redirect:/memlist";
		else
			return "redirect:/err.html";
	}
}

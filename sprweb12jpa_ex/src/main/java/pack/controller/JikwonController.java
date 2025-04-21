package pack.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import pack.model.DataDao;
import pack.model.JikwonDto;


@Controller
public class JikwonController {
	@Autowired
	private DataDao dataDao;
	
	@GetMapping("jikwonjpa")
	public String listProcess(Model model) {	//전체 자료 읽기
		ArrayList<JikwonDto> jlist = (ArrayList<JikwonDto>) dataDao.getDataAll();
		model.addAttribute("datas",jlist);
		return "list";
	}
	
	@GetMapping("search")
	public String searchProcess(FormBean formBean, Model model) {
		ArrayList<JikwonDto> jlist = (ArrayList<JikwonDto>) dataDao.getDataSearch(formBean.getSearchValue());
		model.addAttribute("datas",jlist);
		return "list";
	}
}

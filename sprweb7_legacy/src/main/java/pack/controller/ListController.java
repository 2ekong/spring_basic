package pack.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import pack.model.DataDao;
import pack.model.SangpumDto;

@Controller
public class ListController {
	@Autowired
	private DataDao dataDao;
	@GetMapping("testdb")
	public String listProcess(Model model) {
		ArrayList<SangpumDto> list = dataDao.getDataAll();	//모델 호출
		model.addAttribute("datas",list);
		return "list";
	}
}

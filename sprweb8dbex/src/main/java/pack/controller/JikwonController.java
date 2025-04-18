package pack.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pack.model.JikwonDao;
import pack.model.JikwonDto;

@Controller
public class JikwonController {
	@Autowired
	private JikwonDao jikwonDao;
	
	@GetMapping("input")
	public String listProcess(Model model, @RequestParam("jikwonjik")String jikwonjik) {
		ArrayList<JikwonDto> list = jikwonDao.getJikwonData(jikwonjik);   // 모델 호출
        model.addAttribute("jikwon", list);
        return "list";
	}
	
}

package pack.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pack.model.BuserDto;
import pack.model.DataDao;
import pack.model.GogekDto;
import pack.model.JikwonDto;

@Controller
public class DataController {
	
	@Autowired
	private DataDao dataDao;
	
	@GetMapping("gogeklist")
	public String gogekProcess(Model model) {
		List<GogekDto> glist = dataDao.gogekList();
		model.addAttribute("glist", glist);
		return "list";
	}
	
	@GetMapping("search")
	@ResponseBody
	public Map<String, Object> searchGogek(@RequestParam("gogekno")int gogekno,@RequestParam("gogekname")String gogekname){
		Map<String, Object> map = new HashMap<String, Object>();
		
		GogekDto gogekDto = dataDao.findGogek(gogekno, gogekname);
		if(gogekDto != null) {
			int jikwonno = gogekDto.getGogekdamsano();
			JikwonDto jikwonDto = dataDao.findJikwon(jikwonno);
			
			if(jikwonDto != null) {
				BuserDto buserDto = dataDao.findBuser(jikwonDto.getBuser());
				Map<String, Object> result = new HashMap<String, Object>();
				result.put("jikwonname", jikwonDto.getJikwonname());
				result.put("jikwonjik", jikwonDto.getJikwonjik());
				result.put("busername", buserDto.getBusername());
				result.put("busertel", buserDto.getBusertel());
				map.put("data", result);
			}else {
				map.put("error", "담당 직원을 찾을수 없습니다.");
			}
		}else {
			map.put("error", "고객 정보가 없습니다.");
		}
		
		return map;
	}
}

package pack;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import pack.good.DataVo;

@Controller	//객체 생성. 사용자의 요청 처리한 후 지정된 뷰에 모델 객체를 넘겨주는 역할
public class TestController {
	@RequestMapping("test1")	// 클라이언트의 요청과 매핑 - 내부적으로 viwResolver 사용
	public ModelAndView abc() {
		String msg = "첫번째 요청 처리 성공";	//Model을 통해 결과를 얻었다고 가정
		
//		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.setViewName("list");
//		modelAndView.addObject("msg", msg);	//request.setAttribute("msg",msg)
//		return modelAndView;
		
		return new ModelAndView("list","msg",msg);	//(view 파일명, model 명, value)
		
	}
	
	@RequestMapping(value = "test2", method = RequestMethod.GET)
	public ModelAndView abc2() {
		return new ModelAndView("list","msg","성공2");
	}
	
	//@GetMapping(value = "test3") //24번줄과 동일
	@GetMapping(value = {"test3","testgood","nice"})	
	public ModelAndView abc3() {
		return new ModelAndView("list","msg","성공3");
	}
	
	
	@GetMapping(value = "test4")
	public String abc4(Model model) {
		model.addAttribute("msg","성공4");
		return "list";	//파일명
	}
	
	@RequestMapping(value = "test5", method = RequestMethod.POST)
	public ModelAndView abc5() {
		return new ModelAndView("list","msg","성공5");
	}
	
	@PostMapping(value = "test6")
	public ModelAndView abc6() {
		return new ModelAndView("list","msg","성공6");
	}
	
	
	@PostMapping("test7")
	public String abc7(Model model) {
		model.addAttribute("msg","성공7");
		return "list";	//파일명
	}
	
	@GetMapping("test8")
	@ResponseBody	//그대로 반환
	public String abc8() {
		String value = "일반데이터-String, Map, JSON 등을 전달";
		return value;
	}
	
	@GetMapping("test8_1")
	@ResponseBody	//그대로 반환
	public DataVo abc8_1() {
		DataVo dataVo = new DataVo();
		dataVo.setCode(10);
		dataVo.setName("한국인");
		return dataVo;
	}
	
	@GetMapping("test8_2")
	@ResponseBody	//그대로 반환
	public List<DataVo> abc8_2() {
		List<DataVo> list = new ArrayList<DataVo>();
		for(int i =1; i<=5; i++) {
			DataVo dataVo = new DataVo();
			dataVo.setCode(i);
			dataVo.setName("한국인" + i);
			list.add(dataVo);
		}
		return list;
	}
	
}

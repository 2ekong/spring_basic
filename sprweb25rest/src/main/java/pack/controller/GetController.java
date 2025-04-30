package pack.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@Controller
//@ResponseBody
@RestController	//위에 두개를 더한것
public class GetController {
	@GetMapping("/hello")
	public String abc() {
		System.out.println("요청 1 접수");
		return "Hello ~";
	}
	
	@GetMapping(value = "/hello/{info}")
	public String abc2(@PathVariable("info")String info) {
		System.out.println("요청 2 접수");
		return info;
	}
	
	@GetMapping(value = "/world")
	public String abc3(@RequestParam("name")String irum, @RequestParam("age")int nai) {
		System.out.println("요청 3 접수");
		return irum + nai;
	}
}

package pack.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {
	@PostMapping(value = "hipost")
	public String post1() {
		System.out.println("post 요청 접수1");
		 return "post 요청 1결과";
	}
	
	@PostMapping(value = "hiform")	//?name=name&addr=addr
	public String post2(@RequestParam("name")String name,@RequestParam("addr") String addr ) {
		System.out.println("post 요청 접수2");
		return name + addr;
	}
	
	@PostMapping(value = "hiform2")	//{name:name,addr:addr}
	public String post3(@RequestBody Map<String,String>postData ) {
		String name = postData.get("name");
		String addr = postData.get("addr");
		System.out.println("post 요청 접수3 - json data");
		return "이름 : " + name + ", 주소 : " +addr;
	}
	
	@PostMapping(value = "hiform3")	//받아올게 양이 많을 때 ?name=name&addr=addr...
	public String post4(PostDataBean postData ) {
		String name = postData.getName();
		String addr = postData.getAddr();
		System.out.println("post 요청 접수4 - json data");
		return "이름 : " + name + ", 주소 : " +addr;
	}
}

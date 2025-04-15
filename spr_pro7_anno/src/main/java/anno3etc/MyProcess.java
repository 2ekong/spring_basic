package anno3etc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("my")
public class MyProcess {
	
	private String name;
	
	private String part;
	
	public MyProcess() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	//public MyProcess(@Value("총무부") String part) {
	public MyProcess(@Value("#{dataInfo.part}") String part) {	//spEL을 사용
		this.part = part;
	}
	
	@Value("30")
	private int age;
	
	public void showDatas() {
		System.out.println("part : " + part);
		System.out.println("age : " + age);
	}
}

package pack.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import lombok.AllArgsConstructor;
import pack.model.TodoEntity;
import pack.model.TodoResponse;
import pack.model.TodoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*")	//다른 도메인에서 서버에 요청은 차단됨.모든 도메인 요청을 허용. origins = "http://localhost:3000"
@RequestMapping("/api")
public class TodoController {
	private final TodoService service;
	
	@PostMapping
	public ResponseEntity<TodoResponse> create(@RequestBody TodoRequest request) {
		System.out.println("create(insert)");
		//return null;
		
		if(ObjectUtils.isEmpty(request.getTitle())) {
			return ResponseEntity.badRequest().build();	//에러가 있는 경우 에러 코드를 리턴
		}
		
		if(ObjectUtils.isEmpty(request.getOrder())) 
			request.setOrder(0);	//order가 없는경우 0으로 설정
		
		if(ObjectUtils.isEmpty(request.getCompleted())) 
			request.setCompleted(false);	//completed가 없는경우 false로 설정
	
		TodoEntity entity = service.add(request);	//insert 처리 후 결과 반환
		System.out.println("insert result" + ResponseEntity.ok(new TodoResponse(entity)));
		
		return ResponseEntity.ok(new TodoResponse(entity));	//변수 = 값 형식(JSON)으로 반환
	}
	
	@GetMapping
	public ResponseEntity<List<TodoResponse>> readAll(){
		System.out.println("readAll");
		//return null;
		List<TodoEntity> list = service.searchAll();
		//Entity를 Dto로 변환
		List<TodoResponse> response = list.stream().map(TodoResponse::new).collect(Collectors.toList());
		//new는 new TodoREsponse(todo엔티티)를 의미
		System.out.println("readAll result : " + ResponseEntity.ok(response));
		return ResponseEntity.ok(response);
	}
	
	@GetMapping(value = "{id}")
	public ResponseEntity<TodoResponse> readOne(@PathVariable(name = "id") Integer id){	//{id}이렇게 받아오려면 @PathVariable으로 받아와야함
		System.out.println("readOne");
		//return null;
		TodoEntity entity = service.searchById(id);
		//생성자를 통해서 Entity를 Dto로 변환 후 반환
		return ResponseEntity.ok(new TodoResponse(entity));
	}

	@PatchMapping("{id}")
	public ResponseEntity<TodoEntity> update(@PathVariable(name = "id") Integer id, @RequestBody TodoRequest request){
		System.out.println("update");
		TodoEntity entity = service.updateById(id, request);
		System.out.println("readAll result : " + ResponseEntity.ok(entity));
		return ResponseEntity.ok(entity);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteOne(@PathVariable(name="id")Integer id){
		System.out.println("delete");
		service.deleteById(id);
		System.out.println("readAll result : " + ResponseEntity.ok());
		return ResponseEntity.ok().build();	//넘어갈것이 없으니 200 ok만 반환.처리 성공만 알림
	}
	
	@DeleteMapping("")
	public ResponseEntity<?> deleteAll(){
		System.out.println("deleteAll");
		service.deleteAll();
		System.out.println("readAll result : " + ResponseEntity.ok());
		return ResponseEntity.ok().build();	//넘어갈것이 없으니 200 ok만 반환.처리 성공만 알림
	}
}

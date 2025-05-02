package pack.model;

import java.util.List;

import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import lombok.AllArgsConstructor;
import pack.controller.TodoRequest;

//@Repository
@Service
@AllArgsConstructor
public class TodoService {
	private final TodoRepository todoRepository;
	
	//일정 관리 목록에 아이템 추가
	public TodoEntity add(TodoRequest request) {	//insert
		TodoEntity todoEntity = new TodoEntity();
		todoEntity.setTitle(request.getTitle());
		todoEntity.setOrder(request.getOrder());
		todoEntity.setCompleted(request.getCompleted());
		return this.todoRepository.save(todoEntity);	//save는 제네릭으로 받은 타입을 반환
	}
	
	//일정 관리 목록 특정 아이템 조회
	public TodoEntity searchById(Integer id) {
		System.out.println("searchById : " + id);
		return this.todoRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	//일정 관리 목록 전체 조회
	public List<TodoEntity> searchAll() {
		return this.todoRepository.findAll();
	}
	
	//일정 관리 목록 특정 아이템 수정
	public TodoEntity updateById(Integer id, TodoRequest request) {	//TodoRequest에 id가 없기에 같이 가지고 와야함
		TodoEntity todoEntity = searchById(id);	//수정 대상 레코드 일기
		if(request.getTitle() != null) {
			todoEntity.setTitle(request.getTitle());	//수정 자료로 원본 자료를 덮어쓰기
		}
		if(request.getOrder() != null) {
			todoEntity.setOrder(request.getOrder());	//수정 자료로 원본 자료를 덮어쓰기
		}
		if(request.getCompleted() != null) {
			todoEntity.setCompleted(request.getCompleted());	//수정 자료로 원본 자료를 덮어쓰기
		}
		
		return todoRepository.save(todoEntity);
	}
	
	//일정 관리 목록 특정 아이템 삭제
	public void deleteById(Integer id) {
		todoRepository.deleteById(id);
	}
	
	//일정 관리 목록 특정 아이템 삭제
	public void deleteAll() {
		todoRepository.deleteAll();
	}
	
}
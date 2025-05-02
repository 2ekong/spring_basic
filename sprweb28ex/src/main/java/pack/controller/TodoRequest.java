package pack.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class TodoRequest {	//FormBean 역할
	//private Integer id;	//id는 자동증가이므로 제외
	private String title;
	private Integer order;
	private Boolean completed;
}

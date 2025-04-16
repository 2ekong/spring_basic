package pack.model;

import org.springframework.stereotype.Service;

import pack.controller.InputBean;

@Service
public class ScoreModel {
	public String Result(InputBean bean) {
		String data = "결과는 " + bean.getName() + "님의 촘점은 " +  bean.getTotal() + " 평균은 " + bean.getAverage();
		return data;
	}
}

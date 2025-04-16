package pack.controller;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InputBean {
	private String name;
	private int j;
	private int p;
	
	public int getTotal() {
		return j + p;
	}

	public double getAverage() {
		return (j + p) / 2.0;
	}
}

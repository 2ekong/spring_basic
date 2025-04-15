package pack.controller;

import java.util.Scanner;

import pack.model.SangpumInter;

public class MyImpl implements MyInter{
	private SangpumInter sangpumInter;
	private String sang;
	private int re;
	
	public MyImpl(SangpumInter sangpumInter) {
		this.sangpumInter = sangpumInter;
	}
	
	@Override
	public void inputData() {
		Scanner sc = new Scanner(System.in);
		System.out.print("상품명: ");
		sang = sc.nextLine();
		System.out.print("수량: ");
		int su = sc.nextInt();
		System.out.print("단가: ");
		int dan = sc.nextInt();
		re = sangpumInter.calcMoney(su, dan);
	}
	
	@Override
	public void showResult() {
		System.out.println("상품: " + sang + ", 금액은 " + re + "원 입니다");
	}
}

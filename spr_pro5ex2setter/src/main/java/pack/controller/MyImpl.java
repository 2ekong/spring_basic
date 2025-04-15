package pack.controller;

import pack.model.SangpumInter;
import java.util.Scanner;

public class MyImpl implements MyInter {
    private SangpumInter sangpumInter;

    public void setSangpumInter(SangpumInter sangpumInter) {
        this.sangpumInter = sangpumInter;
    }

    @Override
    public void inputData() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("상품명: ");
        sangpumInter.setProductName(scanner.nextLine());

        System.out.print("수량: ");
        sangpumInter.setQuantity(scanner.nextInt());

        System.out.print("단가: ");
        sangpumInter.setPrice(scanner.nextInt());
        
    }
    
    @Override
    public void showResult() {
        System.out.println(sangpumInter.calcMoney());
    }
}


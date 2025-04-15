package pack.model;

public class SangpumImpl implements SangpumInter {
	private String productName;
    private int quantity;
    private int price;
	
    public void setProductName(String productName) {
		this.productName = productName;
	}
    
    public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
    
    public void setPrice(int price) {
		this.price = price;
	}
    
	@Override
    public String calcMoney() {
        return "상품 " + productName + " : 의 가격은" + quantity * price + "입니다.";
    }
}

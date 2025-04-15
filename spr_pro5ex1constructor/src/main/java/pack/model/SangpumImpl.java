package pack.model;

public class SangpumImpl implements SangpumInter{
	@Override
	public int calcMoney(int su, int dan) {
		return su * dan;
	}
}

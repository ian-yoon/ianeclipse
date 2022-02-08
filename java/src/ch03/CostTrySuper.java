package ch03;

public class CostTrySuper {

	public static void main(String[] args) {
		
		CostTry ct = new CostTry();
		ct.setName("Ian");
		ct.setPrice(30000);
		ct.setPoint(50000);
		ct.getPay();
		
		System.out.println(ct.getPay());

	}

}

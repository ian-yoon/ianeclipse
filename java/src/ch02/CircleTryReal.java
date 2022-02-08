package ch02;

public class CircleTryReal {

	public static void main(String[] args) {
		CircleTry ct = new CircleTry();
		ct.setRound(10);
		System.out.println(String.format("%.2f", ct.getLength()));
		System.out.println(String.format("%.2f", ct.getArea()));
		

	}

}

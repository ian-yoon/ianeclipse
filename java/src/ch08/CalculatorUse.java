package ch08;

public class CalculatorUse {

	public static void main(String[] args) {
		Calculator c1 = new Calculator();
		c1.setLeft(5);
		c1.setRight(10);
		c1.sum();
		c1.avg();

		Calculator c2 = new Calculator(5, 10);
		c2.sum();
		c2.avg();

	}

}

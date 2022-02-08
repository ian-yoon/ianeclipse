package ch02;

public class CircleTry {
	
	private double round;
	private double length;
	private double area;

	public double getRound() {
		return round;
	}

	public void setRound(double round) {
		this.round = round;
	}

	public double getLength() {
		return length = 2 * Math.PI * round;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getArea() {
		return area = Math.PI * round * round;
	}

	public void setArea(double area) {
		this.area = area;
	}

	public void showCircle() {
		System.out.println("원의 반지름: " + round);
		System.out.println("원의 둘레: " + length);
		System.out.println("원의 넓이: " + area);
	}
}

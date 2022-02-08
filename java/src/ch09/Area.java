package ch09;

public class Area {

	// 가로 길이, 세로 길이 입력해서 넓이를 구하기

	private int width;
	private int length;

	public Area() {
	}

	public Area(int width, int length) {
		this.width = width;
		this.length = length;
	}

	public int getArea() {
		return width * length;
	}

}

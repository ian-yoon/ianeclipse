package ch09;

public class Volume extends Area {

	// Area 클래스를 상속받아 부피 구하는 공식으로 발전

	private int height;

	public Volume() {
	}

	public Volume(int width, int length, int height) {
		super(width, length);
		this.height = height;
	}

	public int getVolume() {
		return getArea() * height;
	}

}

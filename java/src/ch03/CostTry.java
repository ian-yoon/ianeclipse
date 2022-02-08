package ch03;

public class CostTry {
	String name;
	int price;
	int fee;
	int pay;
	int point;
	int point_use;

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		if (price > 20000) {
			fee = 0;
		} else {
			fee = 2000;
		}
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPay() {
		return pay;
	}

	public void setPay(int pay) {
		this.pay = pay;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		if (point > price) {
			point_use = price;
		} else {
			point_use = point;
		}
		pay = price + fee - point_use;
		this.point=point;
	}

}

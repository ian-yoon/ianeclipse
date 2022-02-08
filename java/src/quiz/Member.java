package quiz;

public class Member {
	// 이름,나이,신장,체중,bmi
	private String name;
	private int age;
	private double height;
	private double weight;
	private double bmi;
	private String status;

	public Member() { }

	public Member(String name, int age, int height, int weight) {
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;

		calc();
	}

	public void calc() {
		bmi = weight / ((height/100) * (height/100)) ;
		// Bmi의 값은 체중(kg)/ 키(m)의 제곱으로 계산하며
		// bmi의 값이 18.5 미만이면 저체중,
		// 18.5~22.9 정상, 23.0 ~ 24.9 과체중,
		// 25.0 이상 비만으로 처리한다.
		if (bmi < 18.5) {
			status = "저체중";
		} else if (bmi <= 22.9) {
			status = "정상";
		} else if (bmi <= 24.9) {
			status = "과체중";
		} else {
			status = "비만";
		}
	}

	@Override
	public String toString() {
		String str = "이름:" + name + 
				"\n나이:" + age + "\n신장:" 
				+ height + "\n체중:" + weight 
				+ "\nBMI:" + String.format("%.2f", bmi) + "\n결과:" + status;
		return str;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getBmi() {
		return bmi;
	}

	public void setBmi(double bmi) {
		this.bmi = bmi;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}

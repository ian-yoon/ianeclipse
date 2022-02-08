package quiz;

public class Quiz14_try {

	private String name;
	private int age;
	private double height;
	private double weight;
	private double bmi;
	private String bmi_check;

	public Quiz14_try() {
	}

	public Quiz14_try(String name, int age, double height, double weight) {
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;

		calc();

	}

	public void calc() {
		bmi = weight / Math.pow(height, 2);
		if (bmi < 18.5) {
			bmi_check = "저체중";
		} else if (bmi >= 18.5 && bmi <= 22.9) {
			bmi_check = "정상";
		} else if (bmi >= 23.0 && bmi <= 24.9) {
			bmi_check = "과체중";
		} else {
			bmi_check = "비만";
		}
	}

	@Override
	public String toString() {
		return "회원이름: " + name + "\n" + "나이: " + age + "\n" + "신장: " + height + "\n" + "체중: " + weight + "\n" + "BMI: "
				+ String.format("%.2f", getBmi()) + "\n" + bmi_check + "입니다.";

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

	public String getBmi_check() {
		return bmi_check;
	}

	public void setBmi_check(String bmi_check) {
		this.bmi_check = bmi_check;
	}

}

package ch03;

public class Point1Again {
	int point;
	String grade;

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public String getGrade() {
		if (point >= 90 && point <= 100) {
			grade = "A";
		} else if (point >= 80 && point < 90) {
			grade = "B";
		} else if (point >= 70 && point < 80) {
			grade = "C";
		} else if (point >= 60 && point < 70) {
			grade = "D";
		} else {
			grade = "F";
		}
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

}

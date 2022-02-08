package ch03;

public class Point2Again {
	int java;
	int db;
	int math;
	int tot;
	double avg;
	String grade;
	
	public int getTot() {
		tot = java + db + math;
		return tot;
	}
	
	public double getAvg() {
		avg = tot / 3.0;
		return avg;
	}

	public int getJava() {
		return java;
	}

	public void setJava(int java) {
		this.java = java;
	}

	public int getDb() {
		return db;
	}

	public void setDb(int db) {
		this.db = db;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public String getGrade() {
		if (avg >= 90 && avg <= 100) {
			grade = "A";
		} else if (avg >= 80 && avg < 90) {
			grade = "B";
		} else if (avg >= 70 && avg < 80) {
			grade = "C";
		} else if (avg >= 60 && avg < 70) {
			grade = "D";
		} else {
			grade = "F";
		}
		return grade;
	}

	public void setGrade(String grade) {
		if (avg >= 90 && avg <= 100) {
			grade = "A";
		} else if (avg >= 80 && avg < 90) {
			grade = "B";
		} else if (avg >= 70 && avg < 80) {
			grade = "C";
		} else if (avg >= 60 && avg < 70) {
			grade = "D";
		} else {
			grade = "F";
		}
		this.grade = grade;
	}

}

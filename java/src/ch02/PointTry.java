package ch02;

public class PointTry {
	String name;
	int java;
	int db;
	int math;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public void showInfo() {
		int tot = java + db + math;
		double avg = tot / 3.0;
		System.out.println("Name: " + name);
		System.out.println("Java: " + java);
		System.out.println("DB: " + db);
		System.out.println("Math: " + math);
		System.out.println("Tot: " + tot);
		System.out.println("Avg: " + String.format("%5.1f", avg));

	}

}

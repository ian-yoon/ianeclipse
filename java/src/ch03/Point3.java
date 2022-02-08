package ch03;

public class Point3 {

	public static void main(String[] args) {

		int java = 88;
		int db = 99;
		int math = 85;
		int tot = java + db + math;
		double avg = tot / 3.0;
		String grade = "";

		switch ((int) (avg / 10)) {
		case 10:
		case 9:
			grade = "A";
			break;
		case 8:
			grade = "B";
			break;
		case 7:
			grade = "C";
			break;
		case 6:
			grade = "D";
			break;
		default:
			grade = "F";
		}

		System.out.println("JAVA: " + java);
		System.out.println("DB: " + db);
		System.out.println("Math: " + math);
		System.out.println("Total: " + tot);
		System.out.println("Average: " + String.format("%.2f", avg));
		System.out.println("Grade: " + grade);

	}

}

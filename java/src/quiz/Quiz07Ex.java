package quiz;

public class Quiz07Ex {

	private String name;
	private String subject;
	private int grade;
	private int num;
	private int kor;
	private int eng;
	private int math;
	private int tot;
	private double avg;

	public void point(String name, String subject, int grade, int num, int kor, int eng, int math) {
		this.name = name;
		this.subject = subject;
		this.grade = grade;
		this.num = num;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	public int getTotal() {
		tot = kor + eng + math;
		return tot;
	}

	public double getAvg() {
		avg = tot / 3.0;
		return avg;
	}

	public void print() {
		System.out.println("이름: " + name);
		System.out.println("학과: " + subject);
		System.out.println("학년: " + grade);
		System.out.println("학번: " + num);
		System.out.println("국어: " + kor);
		System.out.println("영어: " + eng);
		System.out.println("수학: " + math);
		System.out.println("총점: " + tot);
		System.out.println("평균: " + String.format("%.2f", avg));
	}

}

package ch03;

public class Point2AgainSuper {

	public static void main(String[] args) {
		
		Point2Again p2a = new Point2Again();
		p2a.setJava(100);
		p2a.setDb(90);
		p2a.setMath(95);
		System.out.println(p2a.getTot());
		System.out.println(String.format("%.2f", p2a.getAvg()));
		System.out.println(p2a.getGrade());

	}

}

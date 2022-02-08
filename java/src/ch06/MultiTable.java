package ch06;

public class MultiTable {
	static void table(int dan) {
		System.out.println("\n" + "=== Table " + dan + " ===");
		for (int i=1; i<=9; i++) {
			System.out.println(dan + "x" + i + "=" + (dan * i));
		}
	}
	static void allTable() {
		for (int i=2; i<=9; i++) {
			System.out.println("\n" + "=== Table" + i + " ===");
			for (int j=1; j<=9; j++) {
				System.out.println(i + "x" + j + "=" + i * j);
			}
		}
	}

	public static void main(String[] args) {
		
//		table(3);
//		table(5);
	
		for (int i=2; i<=9; i++) {
			table(i);
		}
		
//		allTable();

	}

}

package ch08;

public class PersonUse {

	public static void main(String[] args) {
		Person p1 = new Person();
		p1.showInfo();
		Person p2 = new Person("Ian");
		p2.showInfo();
		Person p3 = new Person("Endeavour", 190);
		p3.showInfo();
		Person p4 = new Person("Hawks", 172, 55);
		p4.showInfo();

	}

}

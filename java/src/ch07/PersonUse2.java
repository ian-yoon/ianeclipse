package ch07;

public class PersonUse2 {

	public static void main(String[] args) {
		
		Person2 p1 = new Person2();
		p1.setName("Kim"); // p1.name = "김철수";는 이제 안됨.. Person2의 name이 private한 변수이기 때문
		p1.setAge(20);
		p1.setHeight(180.0);
		p1.print();
		
//		p1.print() 함수를 쓰지 않으면
//		System.out.println("이름: "+p1.getName());
//		System.out.println("나이: "+p1.getAge());
//		System.out.println("키: "+p1.getHeight());
//		이렇게 써야 함

	}

}

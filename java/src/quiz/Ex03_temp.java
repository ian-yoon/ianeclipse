package quiz;

public class Ex03_temp {
	//화씨 => 섭씨 계산 함수
	static double degree1(double a) {
		return (a-32)/1.8;
	}
	//섭씨 => 화씨 계산 함수
	//화씨 온도 = (섭씨온도*1.8) + 32
	static double degree2(double a) {
		return (a*1.8)+32;
	}
	
	public static void main(String[] args) {
		double a=100; //화씨 100도는
		System.out.println(degree1(a)); //섭씨 37.7도
		
		double b=37.7777777;
		System.out.println(degree2(b)); 
		
	}
}

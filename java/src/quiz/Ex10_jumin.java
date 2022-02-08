package quiz;

import java.util.Scanner;

public class Ex10_jumin {
	private String jumin;
	private int age;
	private char gender;
	private String strGender;
	private String nation;
	
	public Ex10_jumin(){	}
	
	public void input(){
		Scanner scan=new Scanner(System.in);
		System.out.print("주민등록번호를 입력하세요:");
		jumin= scan.nextLine();
		
		calc();
	}
	public void calc() {
		int base=0;
		//901231-1234567
		gender=jumin.charAt(7);
		switch(gender){ //정수,문자,스트링
		case '1': 
		case '2': 
		case '5': 
		case '6':
			base=1900; break;
		case '3': 
		case '4': 
		case '7': 
		case '8':
			base=2000; break;
		}
		age=2020-(base+Integer.parseInt(jumin.substring(0,2)));
		
		if(gender >= '1' && gender <= '4') {
			nation="내국인";
		}else if(gender >= '5' && gender <= '8'){
			nation="외국인";
		}
		
		switch(gender){
		case '1': case '3': case '5': case '7':
			strGender="남"; break;
		case '2': case '4': case '6': case '8':
			strGender="여"; break;
		}
	}
	
	@Override
	public String toString() {
		String result="국적:"+nation+"\n"
				+"나이:"+age+"\n"
				+"성별:"+strGender;
		return result;
	}
	
	public static void main(String[] args) {
		Ex10_jumin ex=new Ex10_jumin();
		ex.input();
		System.out.println(ex); //toString() 호출
	}
}

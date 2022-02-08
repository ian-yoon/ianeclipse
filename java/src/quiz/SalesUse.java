package quiz;

import java.util.ArrayList;
import java.util.List;

public class SalesUse {
	public static void main(String[] args) {
		Sales[] arr={
			new Sales("001","삼성","냉장고",500000	,10	),
			new Sales("002","LG","TV",800000,20	),
			new Sales("003","대우","세탁기",700000	,25	),
			new Sales("004","삼보","노트북",1000000,30	),
			new Sales("005","애플","아이패드",1000000,40	)
		};
		List<Sales> list=new ArrayList<>();
		Sales s=new Sales();
		s.print(arr,list);
//		for(Sales s : arr) {
//			list.add(s);
//		}
//		for(Sales s : arr) {
//			System.out.println(s);
//		}
	}
}






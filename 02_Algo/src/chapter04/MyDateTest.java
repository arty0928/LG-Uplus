package chapter04;

public class MyDateTest {

	public static void main(String[] args) {

		MyDate d1 = new MyDate();
		
		d1.setYear(2010);
		d1.name = "Uplus";  //default이므로 같은 package 접근 가능
//		d1.year = 2025;
//		d1.month = 13;
//		d1.date = 32;
	}

}

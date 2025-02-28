package chapter04;

public class CustomerTest {

	public static void main(String[] args) {
		
		/*
		 * 객체 선언		클래스명 변수명;
		 * 객체 생성		변수명 = new 클래스명([인자]);
		 * 객체 접근		변수명, 속성명		
		 * 
		 * 선언 & 생성
		 * 클래스명 변수명 = new 클래스명([인자]); 
		 */

//		Customer cust1 = new Customer();
//		cust1.name = "Uplus";
//		cust1.age = 2;
//		cust1.address = "서초구 선릉역";
		
		Customer cust1 = new Customer("Uplus", "서초구", 2);
		
		System.out.println(cust1.toString());
		System.out.println(new Customer("pes","권선동", 26).toString());
		System.out.println(new Customer(null, null, 0).toString());
	}

}

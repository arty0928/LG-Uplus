package chapter04;

import java.util.Calendar;

/**
 * modifier(제어자)
 * 
 * access modifier		public 	protected	생략(default)	private
 * usage  modifier		abstract	static	final
 * 
 * access modifier	: 클래스, 메서드, 속성에 대한 접근을 제한한다.
 * 
 * 		public 		: 접근 제한이 전혀 없다.
 * 					  setter, getter  
 *
 * 					  사용 이유 : 이제 수정하지 않겠다 -> 수정하면 다른 곳에 영향을 많이 가기 때문에.
 * 								수정될 것 같은 데이터는 private으로 사용.
 * 								
 * 
 * 
 * 		protected	: 상속 관계에서는 제한이 없다. 상속 관계가 아니면 같은 package가 아닌 경우 접근 불가 
 * 					  같은 package + 다른 package의 상속 관계 
 * 
 * 		생략(default): package-private, 즉 같은 패키지 내에서만 접근 가능
 * 
 * 
 * 		private		: 선언한 클래스 내에서만 접근 가능
 * 					  상속관계라도 private은 접근 불가.
 * 					  
 * 		
 * usage  modifier	: 클래스, 메서드, 속성의 기능을 제한한다.
 * 
 * 
 * 
 * 
 * Encapsulation (캡슐화)
 * 	- 대부분의 속성과 일부 메소드를 private, default(생략), protected를 애용해서 캡슐로 쌓는 기능
 *  - 목적
 *    1. 보호
 *    2. 은닉 ==> decouple 효과 , 수정 용이 
 *    
 *  - 접근할 수 있는 public한 메서드(getter, setter)를 제공해야 한다.
 * 
 */
public class MyDate {
	private int year, month, date;
	String name;
	
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		
		if(year < 2024) {
			System.out.println("2024년 이후로 설정해 주세요");
		}else {
			this.year = year;			
		}
		
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}

	
}



















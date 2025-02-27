package chapter04;


/**
 * 	   기계어			: 모든 명령셋이 0 1로 구성되어 있어 기계어로 프로그램 구현하기 어렵다. 
 *  => 어셈블러 		: 명령이 간단한 심볼(fatch, mov)로 구성되어 있어 기계어보다는 쉽지만 여전히 어렵다.  
 *  => 절차식 언어 	: 자연어와 가까워 프로그램을 구현하기 쉬워졌지만 프로그램이 실행 되는 순서대로 
 *  				  모든 코드가 구현되어야 하므로 구현 양이 많아  메모리를 많이 차지하고 프로그램 개발 시간이 오래 걸린다.  
 *  => 구조적 언어 	: 자주 사용하는 코드를 모듈화하여 재사용 함으로서 구현된 코드 양이 적어 빠르고 개발 시간이 적다. 
 *  				  데이타와 코드의 커플링이 너무 높아 수정하기 힘들다.
 *  => 객체 지향언어	: 데이타와 코드의 커플링이 낮아 재사용성과 수정성이 높다. 
 * 
 * 
 * ✅ 객체 지향
 * 캡슐화, 상속, 다형성 => 재사용성과 수정성을 높이기 위한 특징
 * 
 * ✅ 객체
 * - 현실 세계의 모든 것들 ==> 객체 지향에서는 현실 세계의 모든것들이 프로그램의 대상이다
 * - 속성, 행위(메서드)를 가지고 있다.  
 * - 재사용, 우지보수의 단위

 /*
 *  key abstraction 
 *   -무수히 많은 객체 중에서 프로그램에 필요한 객체를 선정하고
 *    객체에 무수히 많은 속성과 기능 중에서 프로그램에 필요한 속성, 메서드를 추출하여 
 *    클래스를 정의 하는 과정 
 *    
 * 명세서(요구사항 정의서-> 유즈케이스 명세서)와  다양한 워크 문서들 통해
 * 명사(데이타)와 동사(기능)을 추출
 * 
 */
 
 /* 
 * ✅ 클래스
 *  - 객체의 속성과 행위를 선언해서 생성을 통해 객체를 생성할 수 있는 대상
 *    => 속성과 메서드 코드가 객체 생성을 통해 메모리에 올라가므로 매번 필요할 때마다 선언할 필요가 없다.   
 */

/*
 * [modifiers] class 클래스 이름{
 * 		// 속성 선언
 * 		[modifiers] DataType 속성명;
 * 		
 * 		// 생성자
 * 		[ access_modifier] 클래스이름([인자,...]){}
 * 	
 * 		// 메서드
 * 		[modifier] 리턴타입 메서드이름([인자,...]){
 * 			[return [데이터]];
 * 		}	
 * }
 */

// 클래스는 재사용성 위함 -> private, static, protected 다 안됨. public만 됨 => top class, enclosing class라고 부름.
/*
 * private
 * 		- 해당 클래스 내에서만 접근 가능
 * 
 * 
 * public
 * 		- 모든 클래스에서 접근 가능. 
 * 		- 다른 클래스나 패키지에서 접근 가능
 * 	
 * 
 * protected
 *      - 같은 패키지 내의 다른 클래스 및 상속받은 클래스에서 접근 가능
 *      - 상속 관계에서 자식 클래스가 부모 클래스의 멤버에 접근하도록
 * 
 * 
 * static
 * 		- 클래스에 속하는 멤버, 인스턴스화하지 않고도 접근 가능
 *      - 클래스의 모든 인스턴스가 공유해야 하는 값이나 메서드를 정의할 때 사용
 *      
 *      
 * 접근 제어자 : private, public, protected
 * 
 */



//한 클래스 내의 public class는 단 하나
// public class는 파일 이름과 동일.

public class Customer {

	// 속성은 초기화를 하지 않아도 됨. new에서 생성하면서 초기화해주니까. (new 할 때 메모리 할당)
	/*
	 * - 속성은 객체가 생성(new) 될때 기본값으로 초기화 된다.
	 * 		정수 : 0
	 * 		실수 : 0.0
	 * 		논리 : false
	 * 		문자 : \u0000
	 * 		객체 : null
	 * 			- 기본 값이 아닌 다른 값으로 설정할 때만 속성명 
	 * 
	 */
	String name;
	String address;
	int    age;
	
	/*
	 * 클래스 내에 선언한 클래스는 Nested(중첩된) class
	 * -> Nested class를 가지고 있으므로 enclosing class라고도 함.
	 */
	static private class MyClass{}
	
	
	/**
	 * 생성자 Overloading
	 * 동일한 이름의 생성자를 인자(인자의 개수, 인자 타입, 인자의 순서)가 다르게 해서 
	 * 한개 이상 선언할 수 있다. 
	 */
	
	public Customer(String name, String address, int age){
		
		/**
		 * this : this는   this를 작성한 클래스로 부터 생성된 객체 중 현재 사용 중인 객체를 참조  
		 *  1. 속성과 로컬변수 이름이 같을 때 구별하기 위해 속성 앞에 this.을 붙인다. 
		 *  2. 코드 재사용을 위해 인자가 다른 생성자를 호출할 때 this(~)를 사용한다. 
		 *      주의점: 생성자 호출(new : 메모리 할당이 진행됨) 은 생성자의 첫번째 명령에서만 호출이 됨.
		 *  3. 클래스 내부에서 해당 클래스의 객체가 필요한 경우 
		 *     ex) 이벤트 처리     
		 */

		this.name = name;
		this.address = address;
		this.age = age;
		
	}
	
	public Customer() {
		this("Uplus", "서초구",2); // 코드 재사용을 위해 인자가 다른 생성자를 호출

	}
	
//	-> 이 public Customer 를 주석 처리해도 에러 안남. 왜?
//			default Constructor
//				- 클래스 내에 생성자가 한개도 없으면 컴파일러가 no-arg, no-body 인 생성자를 작성.
//				==> 클래스 내에 생성자가 있다면 컴파일러가 default Constructor를 만들지 않는다.
	

	// 컴파일러가 컴파일할 때 앞에 this. 을 다 붙여줌. 
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder(50);
		builder.append("Customer [name=");
		builder.append(this.name);
		builder.append(", address=");
		builder.append(this.address);
		builder.append(", age=");
		builder.append(this.age);
		builder.append("]");
		
		return builder.toString();
	}

	// 객체의 내용을 문자열로 리턴하는 기능
	
}







package datastructure_0214;

import java.util.HashSet;
import java.util.TreeSet;

import chapter06.Employee;

/**
 * 
 * [ Set ]
 *  - 동일한 객체를 저장 X  
 *    => 데이타의 유니크성 보장
 *     
 *  - add(Object o), contains(Object o), remove(Object o)에서 
 *    equals(Object o)와 hashCode()를  호출하여 객체가 같은지 비교한다.
 *  
 *  - 데이타를 저장한 순서대로 저장 X 
 *  - index X
 * 
 *  
 * [ TreeSet ]
 *  - set과 동일하게 유니크성을 보장하면서 tree를 이용해서 정렬을 유지한다. 
 *    ==> 정렬시 Comparable interface의 compareTo()를 이용하므로 
 *        저장할 객체에 Comparable interface 구현해야 된다.   
 */
public class SetTest {
	public static void main(String[] args) {
		HashSet<String> set1 = new HashSet<>();
		System.out.println(set1.add("hello"));
		System.out.println(set1.add("hello"));
		System.out.println(set1.add("world"));
		System.out.println(set1.add("ssafy"));
		System.out.println(set1);
		
		HashSet<Employee> set3 = new HashSet<>();
		
		// 이 둘은 각각 다른 객체 -> 다른 hashcode 각각 2개 모두 포함됨
		// -> Employee 클래스에서 hashCode 메서드 호출하면(같은 속성 값이면 같은 hashCode로) hashCode override로 이제는 하나만 들어감.
		
		// 같은 속성을 가진 객체는 하나만 넣고 싶다면 
		//		hashCode, equals 메서드 필수
		Employee emp1 = new Employee("1", "1", 0);
		Employee emp2 = new Employee("1", "1", 0);
		
		System.out.println(set3.add(emp1)); 
		System.out.println(set3.add(emp2));
		
		System.out.println("emp1 : " + emp1.hashCode());
		System.out.println("emp2 : " + emp2.hashCode());
		
		System.out.println("emp2 == emp1 : " + (emp1 == emp2)); //false
		System.out.println(set3);
		
		
		
		System.out.println("------------------ Tree Set -------------------");
		
		TreeSet<String> set2 = new TreeSet<>();
		System.out.println(set2.add("UPlus"));
		System.out.println(set2.add("hello"));
		System.out.println(set2.add("world"));
		
		//그냥 출력하면 내부적으로 정렬이 안된 것처럼 보이지만, for문으로 하나씩 출력하면 tree 형태 구조에서 하나씩 가져옴. 
		for (String str : set2) {
			System.out.println(str);
		}
	}
}













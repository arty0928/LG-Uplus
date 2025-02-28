package chapter06;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/*
 * Comparable
 *   - Arrays.sort(객체배열), Collections.sort(Collection)
 *   함수를 통해 정렬할 때 어떤 기준으로 정렬할지 compareTo()로 지정하기 위한 interface
 *   - 정렬하려는 객체의 클래스에서 Comparable를 상속받는다.. 
 *     ex) Employee 객체들을 정렬하기 위해서는 Employee 클래스에 Comparable 선언한다. 
 *     
 * Comparator    
 *   - Arrays.sort(객체배열, Comparator), Collections.sort(Collection, Comparator)
 *   함수를 통해 정렬할 때 어떤 기준으로 정렬할지 compare()로 지정하기 위한 interface
 * 
 *   - sort() 함수의 두번째 인자로 Comparator를 전달한다. 
 *  
 */
public class ComparableTest {
	public static void main(String[] args) {
		Employee[] emps = { 
				new Employee("2", "1", 5),
				new Employee("1", "1", 1),
				new Employee("3", "1", 2),	
		};
		
		Arrays.sort(emps);
		System.out.println(Arrays.toString(emps));
		
		int[] array = {5,4,7,1,9};
		
		// 기본타입 배열 정렬 시, Comparator를 인자로 전달하지 않아도 
		// 		자동으로 오름차순 정렬
		Arrays.sort(array);
		System.out.println(Arrays.toString(array));
		
		/*
		 *  기본 타입을 내림 차순으로 정렬
		 *  	- Comparator를 두번째 인자로 전달해야
		 *  	==> Comparator(컬렉션)의 compare 함수는 객체만 전달 받는다.
		 *  		==> Wrapper 클래스 필요.
		 */
		
		Integer[] array2 = {5,1,7,2};
//		Arrays.sort(array2, new Comparator<Integer>() {
//
//			@Override
//			public int compare(Integer o1, Integer o2) {
//				// TODO Auto-generated method stub
//				return o2-o1;
//			}
//			
//		});
		
		Arrays.sort(array2, (a,b) -> {return b-a;});
		System.out.println(array2);
		
		Arrays.sort(emps, (a,b) -> { return b.getEmpno().compareTo(a.getEmpno());});
		System.out.println(Arrays.toString(emps));
		
		Arrays.sort(array2, Collections.reverseOrder());
		Arrays.sort(emps, new Comparator<Employee>() {

			/*
			 * compare(arg1, arg2)
			 * arg1 : 기준 데이터
			 * arg2 : 비교 데이터
			 * 
			 */
			@Override
			public int compare(Employee o1, Employee o2) {
				
				// 오름차순
//				String empno = o1.getEmpno();
//				return empno.compareTo(o2.getEmpno());
				
				
				// 내림차순
				String empno = o2.getEmpno();
				return empno.compareTo(o1.getEmpno());
				
			}
			
		});
	}

}

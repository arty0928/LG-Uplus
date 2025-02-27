package recursive;

public class RecursiveCallTest4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(fibo(7));

	}
	
	static int fibo(int num) {
		if(num <3) return 1;
		
		return fibo(num-1) + fibo(num-2);
	}

}

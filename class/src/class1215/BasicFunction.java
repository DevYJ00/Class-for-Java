package class1215;

public class BasicFunction {

	// 함수 정의
	static int f1(int x) { //매개변수 유효범위는 메서드 { } 내에서만 
		return 3 + x * 23;
	}
	
	
	static int add(int a, int b) {
		return a+b;
	}
	
	
	static void PrintSum(int sum) {
		System.out.println(sum);
	}

	public static void main(String[] args) {

		int result = 3 + 4 * 23 - 23 + 45 + 23;

		System.out.printf("result is %d\n", result);

		result = f1(5) - 23 + 45 + 23 + add(5,9); // f1() : 호출
		
		
		System.out.printf("result is %d\n", result);
		
		PrintSum(add(16,7)); //
		
	}




}

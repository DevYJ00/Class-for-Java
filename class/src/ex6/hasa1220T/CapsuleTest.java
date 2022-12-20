package ex6.hasa1220T;

import java.util.Scanner;

public class CapsuleTest {
	
	
	public static void main(String[] args) {
		
//		Exam  newlec = new Exam(30,30,50); //이건 데이터일 뿐이고
		//입출력을 ExamConsole 클래스!
		
		//composition 방법
		ExamConsole console  = new ExamConsole(); // 이제 우린 데이터가 필요한데 this에 없음
		console.print();
		
	//	association 방법
		ExamConsole console2  = new ExamConsole();
		Exam exam = new Exam(10,10,10);
		console2.setExam(exam);
		console2.print();
		

		
	}

}

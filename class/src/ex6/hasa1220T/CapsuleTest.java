package ex6.hasa1220T;

import java.util.Scanner;

public class CapsuleTest {
	
	
	public static void main(String[] args) {
		
		//1. composition 방법 - 셋트로 한큐에!(일체형)
//		ExamConsole console = new ExamConsole();
//		console.print();
		
		//2. Aggregation 방법 - DIY Exam 객체, ExamConsole 객체 각각 만들어서 조립
		ExamConsole console2 = new ExamConsole(); 
		Exam exam = new Exam(20, 10, 6);
//		console2.print(); //조립 전 - 아직 객체 안넣었으니까 오류나야하는거 아닌가? - 맞음 위에 1번케이스랑 혼용되서 그랫음
		System.out.println("조립 후");
		console2.setExam(exam); //조립
		console2.print();
		
	}

}
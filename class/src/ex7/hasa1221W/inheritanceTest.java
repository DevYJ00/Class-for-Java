package ex7.hasa1221W;

import java.util.Scanner;

public class inheritanceTest {
	
	
	public static void main(String[] args) {
		
		NewlecExam exam = new NewlecExam(1,1,1,1);
		System.out.println(exam.total());
		System.out.println(exam.avg());
		
		Exam exam2 = new NewlecExam(1,1,1,1);
		System.out.println(exam2.total()); //exam2.total() ctrl+space보면 부모꺼 나오는것 처럼 나오는데
		//값은 멀쩡하게 4출력됨
//		ExamConsole console = new ExamConsole();
		
//		console.input();
//		console.print();
		
		
	}

}
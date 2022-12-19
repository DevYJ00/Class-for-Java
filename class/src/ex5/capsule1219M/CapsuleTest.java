package ex5.capsule1219M;

import java.util.Scanner;

public class CapsuleTest {

	
	public static void main(String[] args) {
		//성적 객체를 준비
		//성적 뉴렉성적 = new 성적();
		//Exam exam1 = new Exam();
		Exam 뉴렉성적 = new Exam();
//		뉴렉성적.kor = 3;
//		뉴렉성적.eng = 10;
		뉴렉성적.init();
		뉴렉성적.print();
		
		
		//성적을 입려 받는다
		//inputExam(뉴렉성적) <-이건 그동안 객체지향 모르고 하던 방식 사용 ㄴㄴ
		//뉴렉성적.입력();
		//exam1.input(); <- 객체를 이용(Exam클래스내에 input() 메서드를 만들어야함) || 객체를 이용안하면 inputExam(exam1)
//		뉴렉성적.input(); //객체 뉴렉성적에 있는 정보가 input( )메서드로 넘어간다
		//input() <- 인스턴스 메서드 (인스턴스를 통해서 호출되는 메서드)
		
		
		
		//성적을 출력한다
		//뉴렉성적.출력();
//		뉴렉성적.print();
//		
//		Exam 뉴렉성적2 = new Exam();
//		뉴렉성적2.kor = 5;
//		뉴렉성적2.eng = 55;
//		뉴렉성적2.input();
//		뉴렉성적2.print();
//		
//		Exam 뉴렉성적3  = new Exam(100,100,100);
//		뉴렉성적3.input();
//		뉴렉성적3.print();
//		
		
		
	}

}

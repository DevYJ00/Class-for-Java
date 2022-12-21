package ex7.hasa1221W;

import java.util.Scanner;

public class ExamConsole {

	private Exam exam; //참조변수만 선언해 놓은거고 찐 객체가 필요
	
	//찐 객체 데려올 방법은 2가지! 
	
	//1. Composition (part가 whole에 종속적, 조립된 완성품)
	public ExamConsole() {
//		exam = new Exam();
	}
	
	//2. aggregation(집합. part 변경 가능, DIY)
	public void setExam(Exam exam) {
		this.exam = exam;
	}
	
	public void input() {
		
		Scanner scan = new Scanner(System.in);
		
		int kor;
		do {
			System.out.print("국어 : ");
			kor = scan.nextInt();
			
			if(kor<0 || 100<kor)
				System.out.println("입력 가능 범위 : 0 ~ 100");
		}while(kor<0 || 100 <kor);
		
		exam.setKor(kor); // exam 객체에 값 저장
		
		int eng;
		do {
			System.out.print("영어 : ");
			eng = scan.nextInt();
			
			if(eng<0 || 100<eng)
				System.out.println("입력 가능 범위 : 0 ~ 100");
		}while(eng<0 || 100 <eng);
		
		exam.setEng(eng); // exam 객체에 값 저장
		
		int math;
		do {
			System.out.print("수학 : ");
			math = scan.nextInt();
			
			if(math<0 || 100<math)
				System.out.println("입력 가능 범위 : 0 ~ 100");
		}while(math<0 || 100 <math);
		
		exam.setMath(math); // exam 객체에 값 저장
		
		
	}
	
//	exam.setKor(kor); 
// 메서드 밖에서는 exam객체 사용 못하는 이유. 지금은 사용하고 있는게 아니라 클래스를 정의하고 있는 상태!
// 메서드를 정의할때는 객체를 생성 한 후에 사용한다는 가정이기 때문에 메서드내에서는 객체 사용이 가능한 것
	
	public void print(char ch, int length) {
		System.out.println("영어 성적 : " + exam.getEng());
		System.out.println("수학 성적 : " + exam.getMath());
		System.out.println("국어 성적 : " + exam.getKor());
		System.out.println("총점 : " + exam.total());
		System.out.println("평균 : " + exam.avg());
		
		for(int i = 0; i <length; i++)
			System.out.printf("%c", ch); //구분선 출력
	}
	
	public void print(char ch) {
		print(ch,30); // 구분선 길이 디폴트가 30이라 설정
	}
	
	public void print() {
		print('-');
	}
	
	
}
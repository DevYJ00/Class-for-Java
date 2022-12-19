package ex5.capsule1219M;

import java.util.Scanner;

public class Exam {

	private int kor;
	private int eng;
	private int math;

	public void init() {
	}
	
	public Exam() {
		kor = 30;
		eng = 30;
		math = 30;
		
	}
	public  Exam(int kor, int eng, int math) {
		this.kor = kor;
		this.eng  = eng;
		this.math = math;
	}
	
	
	
	public void input() {
		
		Scanner scan  = new Scanner(System.in);
		
		do {
			System.out.print("국어 : ");
			kor = scan.nextInt();
			
			if(kor<0 || 100<kor)
				System.out.println("입력 가능 범위 : 0~100");
		}while(kor<0 || 100<kor);
		
		
	}

	public void print() {
		
		
		
		System.out.println("영어성적 : " + eng); //eng에 this안써도 사용 가능 this의 객체를 찾아서 읽어줌
		System.out.println("국어성적 : " + kor); //eng에 this안써도 사용 가능 this의 객체를 찾아서 읽어줌
		System.out.println("수학성적 : " + math); //eng에 this안써도 사용 가능 this의 객체를 찾아서 읽어줌
		
	}
	
	

}

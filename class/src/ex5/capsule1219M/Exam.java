package ex5.capsule1219M;

import java.util.Scanner;

public class Exam {

	private int kor;
	private int eng;
	private int math;

	public Exam() {
		this(30, 30, 30);

	}

	public Exam(int kor, int eng, int math) {
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	public void input() {

		Scanner scan = new Scanner(System.in);

		do {
			System.out.print("국어 : ");
			kor = scan.nextInt();

			if (kor < 0 || 100 < kor)
				System.out.println("입력 가능 범위 : 0~100");
		} while (kor < 0 || 100 < kor);

	}

	public void print() {
		print('-'); // 기본값을 가지는 메소드
	}

	public void print(char ch, int length) {

		int total = total();
		double avg = avg(total);

		System.out.println("영어성적 : " + eng);
		System.out.println("국어성적 : " + kor);
		System.out.println("수학성적 : " + math);
		System.out.println("총점 : " + total);
		System.out.println("평균성적 : " + avg);

		for (int i = 0; i < length; i++)
			System.out.printf("%c", ch);
	}

	private double avg(int total) {
		
		
		return total()/3.0;
	}

	private int total() {
		
		return kor + eng + math;
	}

	public void print(char ch) {
		print('-', 30);

	}

}

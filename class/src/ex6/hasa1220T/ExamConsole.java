package ex6.hasa1220T;

import java.util.Scanner;

public class ExamConsole {

	private Exam exam;
	
	public ExamConsole() {
		exam = new Exam();
	}
	public void setExam(Exam exam) {
		this.exam = exam;
	}
	public void input() {

		Scanner scan = new Scanner(System.in);
		int kor;
		do {
			System.out.print("국어 : ");
//			this.exam.kor = scan.nextInt();
			// 임시로
			kor = scan.nextInt();

			if (kor < 0 || 100 < kor)
				System.out.println("입력 가능 범위 : 0~100");
		} while (kor < 0 || 100 < kor);

		exam.setKor(kor);
	}

	public void print(char ch) {
		print('-', 30);

	}

	public void print() {
		print('-'); // 기본값을 가지는 메소드
	}

	public void print(char ch, int length) {

		int total = exam.total();
		double avg = exam.avg(total);

		System.out.println("영어성적 : " + exam.getEng());
		System.out.println("국어성적 : " + exam.getKor());
		System.out.println("수학성적 : " + exam.getMath());
		System.out.println("총점 : " + total);
		System.out.println("평균성적 : " + avg);

		for (int i = 0; i < length; i++)
			System.out.printf("%c", ch);
	}

}

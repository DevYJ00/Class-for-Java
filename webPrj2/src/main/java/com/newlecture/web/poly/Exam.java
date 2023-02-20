package com.newlecture.web.poly;

public class Exam {
	
	private int kor;
	private int eng;
	private int math;
	
	
	public Exam() {	}
	
	
	public Exam(int kor, int eng, int math) {
		super();
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	public int getTotal() {
		return kor + eng + math;
	}


	public int getKor() {
		return kor;
	}




	public void setKor(int kor) {
		this.kor = kor;
	}




	public int getEng() {
		return eng;
	}




	public void setEng(int eng) {
		this.eng = eng;
	}




	public int getMath() {
		return math;
	}




	public void setMath(int math) {
		this.math = math;
	}




	static void printIntro(Banner banner) {
		System.out.println("┌───────────────────────┐");
		// 특정 교육센터 이름이 들어간 부분을 분리 (for 재사용)
		banner.print();
		System.out.println("└───────────────────────┘");
	}
	
	
}

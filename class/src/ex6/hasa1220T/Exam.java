package ex6.hasa1220T;


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



	 double avg(int total) {
		
		
		return total()/3.0;
	}

	 int total() {
		
		return kor + eng + math;
	}
	
	public void setKor(int kor) {
		this.kor = kor;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getEng() {
		return eng;
	}
	public int getMath() {
		return math;
	}

	public int getKor() {
		return kor;
	}

	

}

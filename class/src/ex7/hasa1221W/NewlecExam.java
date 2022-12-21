package ex7.hasa1221W;

public class NewlecExam extends Exam{ //Exam을 틀로 쓰겠다.
	
//	private Exam exam; // Exam을 부품으로 쓰겠다 - Exam이 Exam으로 쓸 수는 없으니까 틀이 맞음!
	private int com;
	
//	public NewlecExam() {
//		kor = 1; //error틀을 내꺼처럼 갖다쓰지만 private인건 쓸 수 없음
// Exam 으로받은 변수에 값을 어떻게 설정할 것인가에 대한 문제가 발생함.
//		setKor(1); //Q1. set이 초기화가 맞나? Q2. 내꺼가 아닌데 내가 해도 되나?
//		 -> 생성자가 초기화 담당자! 클래스내에서 this( )로 호출하듯이 여기서도 틀(부모)의 생성자를 호출
//		내껀 내가 초기화하고, 부모껀 부모가 초기화하고
	
	public NewlecExam() {
//		super(); // Exam객체만 초기화, 다른 생성자 호출이니까 첫번째 줄만 가능
//		this.com = 0;
		//매개변수가 있는 생성자를 이용하려면?
		this(0,0,0,0);
		
	}
	
	@Override
	double avg() {
//		return (super.avg()*3 )/4;  //avg()는 조상이 호출되는데, 조상 avg()에서 자식 total()이 호출되서 이상한 결과가 나왔던 것!
		return total()/4;
	}

	public NewlecExam(int kor, int eng, int math, int com) {
		super(kor,eng,math);
		this.com = com;
	}

	@Override
	int total() {
		return super.total() + com;
	}

	
	
	
	
	} 


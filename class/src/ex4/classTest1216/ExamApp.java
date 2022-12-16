package ex4.classTest1216;

public class ExamApp {

	public static void main(String[] args) { // 캡슐화 목적

		Exam exam1 = new Exam(); // exam1 [kor], [eng], [math] 저장할 수 있는 공간 - Heap에 생성
									// 참조변수 exam1의 공간은 stack에 생성 (변수선언으로 생성되는건 stack)

		exam1.kor = 10; // exam1.kor 의 공간은 heap. 이 공간에 접근하려면 참조변수 exam1을 이용해서 접근
		// exam1 : 스택 kor : 힙
		exam1.eng = 20;
		exam1.math = 30;

		// 출력 함수로
		printExam(exam1);

		Exam[] exams = new Exam[3]; // new Exam[3] : Exam타입 객체를 담을 수 있는 배열 공간만 생성 - 힙
		// 참조변수 exams는 main() 메서드 호출전에 main 스택에 생성이 되고!
		// 이제 밑에서 new Exam() 으로 Exam 객체를 생성해서 배열에 담으면 되는거고!!

//	   exams[0].kor = 10; //exams[0] 이 가리키는 인스턴스가 없어서 NullPointerException

		exams[0] = new Exam(); // 이제 exams[0] 참조변수에 인스턴스를 참조
		exams[0].kor = 10; // 이제 인스턴스가 있으니 ㅇㅋㅇㅋ
		exams[0].eng = 10;
		exams[0].math = 10;

		exams[1] = new Exam();
		exams[1].kor = 20;
		exams[1].eng = 20;
		exams[1].math = 20;

		exams[2] = new Exam();
		exams[2].kor = 30;
		exams[2].eng = 30;
		exams[2].math = 30;

		printExams(exams);

	} // 메인메서드내

	private static void printExam(Exam exam) {
		System.out.printf("국어점수 : %d, 영어점수 : %d, 수학점수 : %d\n", exam.kor, exam.eng, exam.math);
	}

	private static void printExams(Exam[] exams) {
//		for (int i = 0; i < exams.length; i++) {
//			printExam(exams[i]);
//		}
		
		for(int i=0; i<exams.length; i++) {
			Exam exam = exams[i]; //이렇게 담아주는게 더 좋아보임(JS ES6에서는 객체를 받아올때 이렇게 담도록 유도하고 있음)
			printExam(exam);
		}
		
		
	}

}

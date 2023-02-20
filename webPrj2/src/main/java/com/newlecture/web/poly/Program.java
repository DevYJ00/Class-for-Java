package com.newlecture.web.poly;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Program {
    
    public static void main(String[] args) {
    	//1.
    	//참조변수를 특정 타입으로 고정하기 보다는
    	ICTBanner ictbanner = new ICTBanner();
    	
    	//인터페이스를 활용해서 객체만 쉽게 바꿀 수 있도록, 객체만 바뀔 뿐
//    	Banner banner = new ICTBanner(); 
    	Banner banner = new NewlecBanner();
    	Exam.printIntro(banner); //출력 부분은 바뀔 필요가 없음
    	
    	
    	
    	// 2. Inner Class
    	/* 그런데, 수많은 Banner가 만들어질때마다 별도의 클래스를 정의하는건 비효율적임
    	 * Banner 클래스가 하는 역할이라곤, 회사명 찍어내는 메서드 기능 하나뿐이고, main 메서드 내에서만 사용될 뿐!
    	 * 내부 클래스로 정의하자.
   		*/
    	class InnerBanner implements Banner {

			@Override
			public void print() {
				System.out.println("     InnerBanner 교육센터");
				
			}
    		
    	}
//    	Banner banner = new InnerBanner(); - 굳이 참조변수 이름을 붙여줄 필요도 없음
    	Exam.printIntro(new InnerBanner()); 
    	
    	
    	//3. 익명 클래스
    	/*
    	 * 메서드 하나 사용하자고, 별도의 클래스를 선언하고 정의하고 객체를 생성하는게 번거로움
    	 * 생성과 정의를 동시에하자. 
    	 */
    	Exam.printIntro(new Banner() {

			@Override
			public void print() {
				System.out.println("     익명 Banner 교육센터");
			}
    		
    	});
    	
    	//4. 람다식 = 익명 객체. 
    	Exam.printIntro(()-> {
    		System.out.println("     Lamda 교육센터");
    	});
    	
//----------------------------------------------------------------------------------------
    	
    	//람다식 이해를 위한 예제
    	//Comparator, Comparable 인터페이스를 구현할 때 람다식이 이용된다.
    	List numList = new ArrayList();
    	numList.add(5);
    	numList.add(2);
    	numList.add(13);
    	numList.add(-3);
    	
    	System.out.println(numList); // [5, 2, 13, -3]
    	
    	numList.sort(null);
    	System.out.println(numList); //[-3, 2, 5, 13]
    	
    	List strList = new ArrayList();
    	strList.add("13");
    	strList.add("9");
    	strList.add("1");
    	strList.add("2");
    	/*
    	 * List.sort(Comparator c) 즉, 정렬기준으로 Comparator 인터페이스를 구현해야함.
    	 * Comparator 인터페이스는 compare(T o1, T o2) 메서드를 오버라이드 해야함
    	 * 하지만 자주 사용되는 primitive타입과 String 타입은 오름차순으로(ASC) 구현되어 있다.
    	 * 
    	 */
    	System.out.println(strList); //[13, 9, 1, 2]
    	strList.sort(null);
    	System.out.println(strList); //[1, 13, 2, 9]
    	//strList 는 String이기 때문에 '첫 번째 문자열' 을 보고 오름차순으로 정렬

    	//Reference Type일 땐 정렬을 어떻게 할까? 국영수토탈
    
    	List<Exam> stdList = new ArrayList<Exam>();
    	stdList.add(new Exam(100,50,80));
    	stdList.add(new Exam(49,100,100));
    	stdList.add(new Exam(97,10,60));
    	stdList.add(new Exam(49,80,50));
    	
//    	stdList.sort(null); //comparator 구현되지 않아서 런타임 에러.
    	
    	//Comparator 인터페이스 구현
    	//1. 익명객체 이용, 수학점수를 기준으로 정렬
    	Comparator comp = new Comparator<Exam>() {

			@Override
			public int compare(Exam o1, Exam o2) {
				return o1.getKor() - o2.getKor();
			}
    		
    	};
    	//출력
    	System.out.println("정렬 전");
    	for(Exam list : stdList)
    		System.out.println(String.format(" 수학점수 : %d", list.getMath()));
    	stdList.sort(comp); //수학점수 기준 정렬  
    	System.out.println("정렬 후");
    	for(Exam list : stdList)
    		System.out.println(String.format(" 수학점수 : %d", list.getMath())); // <--- 결과값이 이상함.. ArrayList 공부좀해보기 ㅜ
    
//    	
//    	for(Object list : stdList) 
//    		System.out.println(((Exam)list).getClass());
    	
//		ArrayList에 담김 객체를 출력하는 방법도 모르겠음    	
    	
    	//우선, 객체 std1하고 std2를 비교하고 싶다면?!
    	//비교기준을 주어야 함. 
    	
        

    }

}
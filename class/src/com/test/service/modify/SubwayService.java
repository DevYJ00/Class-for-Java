package com.test.service.modify;

import java.util.Scanner;

public class SubwayService { // 서비스에서 가공

	// 필요한 클래스
	private Station station;
	Scanner scan = new Scanner(System.in);
	
	
	
	
	// 지하철
	private String[] subwayStation; // 지하철 역 배열
	private int stationNum; // 지하철 역 갯수 (subwayStation.length 이런식으로 . 으로 접근하는거 좋지 못하다고하셔서)

	public SubwayService() {
		this.station = new Station(); // 생성자에서 주입되니까 composition?
		subwayStation = station.getStation();
		stationNum = station.getStationNum();
	}

	public void run() {
		for (int i = 0; i < 3; i++)
			System.out.println();
		
		System.out.printf("현재역은 %s입니다.\n", subwayStation[0]);
		System.out.println("====================");
		System.out.println("메뉴를 선택하세요.");
		System.out.println("1.탑승  2.상세보기  3.이동  4.종료");
		
		//run 진행 변수
		boolean progress = true;
		while(progress) {
		switch(scan.nextInt()) {
		case 1 :
			join();
			break;
		case 2 :
			status();
			break;
		case 3 :
			move();
			break;
		case 4 :
			progress = !progress;
			
		}
		}

	}

	private void move() {
		
	}

	private void status() {
		// TODO Auto-generated method stub
		
	}

	private void join() {
		//호차별로 탑승가능 여부 알려주고 - 몇호차에 탈지 입력받기
		
	}

}

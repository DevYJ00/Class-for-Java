package com.test.service.modify;

import java.util.Arrays;
import java.util.Scanner;

public class SubwayService { // 서비스에서 가공

	// 필요한 클래스
	private Station station;
	private Car car;
	Scanner scan = new Scanner(System.in);

	// 지하철
	private String[] subwayStations; // 지하철 역 배열(배열 이름은s)

	private int stationNum; // 지하철 역 갯수 (subwayStation.length 이런식으로 . 으로 접근하는거 좋지 못하다고하셔서)

	private String[][] seats; // 차량 배열
	private int numCar; // 차량 대수
	private int capacity; // 차량 수용인원
	int idxSub;
	String curStation;

	public SubwayService() {
		this.station = new Station(); // 생성자에서 주입되니까 composition?
		subwayStations = station.getStation();
		stationNum = station.getStationNum();

		this.car = new Car();
		seats = car.getCar();
		capacity = car.getCapacity();
		numCar = car.getNumCar();
		idxSub = 0;
		curStation = "합정";

	}

	boolean pro = true;

	public void run() {

		// run 진행 변수
		boolean progress = true;
		while (progress) {
			System.out.printf("현재역은 %s입니다.\n", curStation);
			System.out.println("====================");
			System.out.println("메뉴를 선택하세요.");
			System.out.println("1.탑승  2.상세보기  3.이동  4.종료");
			switch (scan.nextInt()) {
			case 1:
				join();
				break;
			case 2:
				status();
				break;
			case 3:
				move();
				break;
			case 4:
				progress = !progress;

			}
		}

	}

	String destination; // 목적지
	int carNum; // 입력받은 차량 호차
	int seat; // 입력받은 좌석
	private void join() {

		// 호차별로 탑승가능 여부 알려주고 - 몇호차에 탈지 입력받기
		car.printCarStatus();

		System.out.println("탑승할 호차와 자리를 선택해 주세요.");
		System.out.println("1.1호차   2.2호차   3.3호차   4.4호차");
		carNum = scan.nextInt();
		System.out.println("1.1번째자리, 2.2번째자리, 3.3번째자리, 4.4번째자리,");
		seat = scan.nextInt();
		System.out.println("목적지를 선택해 주세요.");
		// 내가 탑승한 역 제외하고 출력
		for (int i = 0; i < stationNum; i++)
			if (curStation != subwayStations[i])
				System.out.printf("%d. %s  ", (i + 1), subwayStations[i]);
		System.out.println();
		System.out.println("목적지 >");
		int tmp = scan.nextInt();
		destination = subwayStations[tmp - 1];
		seats[carNum - 1][seat - 1] = destination;

	}

	private void status() {
		car.printCarStatus();
	}

	private void move() {
		boolean direction = true;
		System.out.println("열차가 이동합니다.");
		if (curStation == "아현")
			direction = false;
		if (curStation == "합정")
			direction = true;

		if (direction)
			idxSub++;
		else
			idxSub--;
		curStation = subwayStations[idxSub];
		
		
		getOff();
		

	}
	
	public void getOff() {
		int getOffNum = 0;
		// 역 도착시 하차 목적지랑 역이랑 일치하면 하차
		for (int i = 0; i < numCar; i++) {
			for (int j = 0; j < capacity; j++)
				if (curStation == seats[carNum - 1][seat - 1]) {
					seats[i][j] = "";
					getOffNum++;
				}
		}
		System.out.println(getOffNum +" 명의 승객이 하차합니다.");
	}

}

package com.test.service.modify;

public class Car {
	private String[][] seats;
	private int capacity;
	private int numCar;

	public Car() {
		this.capacity = 4;
		this.numCar = 4;
		this.seats = new String[numCar][capacity];
		initCar(); // 초기화
	}

	public void initCar() { //차량초기화
		for (int i = 0; i < numCar; i++)
			for (int j = 0; j < capacity; j++)
				seats[i][j] = "";
	}

	public void printCarStatus() { //차량 현황 출력
		for (int i = 0; i < numCar; i++) {
			System.out.printf("%d 호차 : ", (i + 1));
			for (int j = 0; j < capacity; j++) {
				if (seats[i][j] != "")
					System.out.printf("[       %s      ]", seats[i][j]);
				else 
					System.out.printf("[ %d. 탑승 가능] ", (j+1));
			}
			System.out.println();
		}
	}

	public String[][] getCar() {
		return seats;
	}

	public void setCar(String[][] car) {
		this.seats = car;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getNumCar() {
		return numCar;
	}

	public void setNumCar(int numCar) {
		this.numCar = numCar;
	}

}

package com.test.service.modify;

public class Vehicle {
	private int vehicleNum; // 차량 댓수
	private int[] vehicle = new int[vehicleNum]; //차량
	
	public Vehicle() {
		this(4);
	}
	
	public Vehicle(int vehicleNum) {
		this.vehicleNum = vehicleNum;
		this.vehicle = new int[vehicleNum];
		
	}
	
	
	
	public int getVehicleNum() {
		return vehicleNum;
	}
	public void setVehicleNum(int vehicleNum) {
		this.vehicleNum = vehicleNum;
	}
	public int[] getVehicle() {
		return vehicle;
	}
	public void setVehicle(int[] vehicle) {
		this.vehicle = vehicle;
	}
	
	
	
}

package com.test.service.modify;

public class Station {

	// 데이터 자체가 여기저기서 쓰일 만한건 클래스내에
	// 가공이 더 되야하는건 Service에서

	private String[] station;
	private int stationNum; // 변수로 잡은건 강사님이 length쓰지말라하셔서, 그리고 나중에 가 값 이용할 때 xxx.length (코드에 . .) 들어간거 안좋음  이거 쓰는것보다 변수로 잡고 쓰는게 좋으니까
	

	public Station() {
		this.station = new String[] {"합정", "홍대","신촌","이대","아현"};
		this.stationNum = 5;
	}


	public String[] getStation() {
		return station;
	}


	public void setStation(String[] station) {
		this.station = station;
	}


	public int getStationNum() {
		return stationNum;
	}


	public void setStationNum(int stationNum) {
		this.stationNum = stationNum;
	}
	
	
	
	//궁금한점! 만약 사용자한테 역 이름을 입력받아서 역도 생성하고 싶다면 생성자를 어떻게 해야하는지? scanner로 입력받은 값을 어떻게 넣을지?
	//이 정도 까지는 아니고, 그냥 Service클래스에서 만드는 사람이 그때 그때 역을 입력한다고 생각해야 할까? - 그러면 여기에서는 station 배열까지만 생성하고, station 배열에 인스턴스를 채워주는 작업은 Service에서? ( 가공 작업은 Serivce 니까?)
	// -> 이 개념은 약간 관리자용, 사용자용 나눠서 개발하지 한 프로그램에 다 떄려넣으면서 고려하지 않음
	//난 두 케이스 다 고려할려고 생성자를 여러개 만들려고 쑈 했지만......
	
	
}

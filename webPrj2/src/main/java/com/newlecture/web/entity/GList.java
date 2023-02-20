package com.newlecture.web.entity;

public class GList<재영> {
	
	// 배열은 배열타입을 뭐로 하느냐에 따라 문제가 있음
	// 또한, 서로 다른 타입을 담고 싶을떄 문제가 있다. 
	
	private 재영[] data;
	private int index;
	private int max; //배열 공간을 늘리기 위한 변수, 컬렉션이 이런 매커니즘으로 늘리는데 컬렉션은 기본 늘리는값있고 매개변수로 입력받아 
	//원하는 길이로도 늘릴 수 있게 해놨다.
	
	
	public void add(재영 n) {
		
		//공간이 부족하면
		if(index == max) {
			//공간 늘리기
			재영[] temp = (재영[])new Object[max+3]; // 이 순간까지는 배열이 temp, data 2개
			for(int i=0; i<max; i++)
				temp[i] = data[i]; // data 배열에 있는 데이터들을 temp 배열에 옮겨담고
			
			data = temp; // temp 참조값을 data로 옮겨준다. 그러면. 참조변수 data가 늘어난 배열을 참조하게 된다.
						// 그러면 기존 배열을 참조하는 참조변수가 없기 떄문에 GC 대상이 된다.
		}
		
		data[index] = n; // add 할 때마다 data배열에 들어가야하는데 인덱스로 들어감
		index ++;
	}
	
	public GList() {
		this.index = 0;
		this.max = 3;
		this.data = (재영[])new Object[max];
	}
	
	public 재영 get(int index) {
		return data[index];
	}
	
	public int size() {
//		return data.length;  //이건 안됨. 배 길이가 3 6 9.. 늘어가는데, 비어있어도 길이로 잡힘
		return index; // index를 이용한다!
	}
	
}

package com.newlecture.web.service;

import java.sql.Connection;

/*
다양한 업무를 처리하기 위한 상관 관계를 잘 아는 사람이 데이터를 조작하도록 한다.
단, 데이터를 조작하기 위한 방법을 몰라도 되도록 하는것은 어떨까?
다음과 같은 것들을 모르고도 자바 지식만으로 업무를 처리할 수 있게하면 좋지 않을까?
예를 들어 어떤 DB를 사용해야하는지, 쿼리를 어떻게 작성해야하는지, 데이터 소스가 다양한데 그것이 어떤 것들을 사용해야 하는지

위와 같이 업무를 나누면 다음과 같은 장점이 존재
-DB가 달라지면 SQL연결, 드라이브 등이 달라지는데 그러면 모든 업무로직 코드를 수정해야 한다.

원래는 Service는 업무로직을 처리하는 클래스이기때문에 데이터를 가져오는 작업을 직접 수행하는게 아니라
그 작업을 대신해주는 대상한테서 받는것이다. ( Controller가 Service한테 위임했던것처럼)


*/


import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.newlecture.web.entity.Menu;
import com.newlecture.web.repository.MenuDao;
import com.newlecture.web.repository.jdbc.JdbcMenuDao;

public class DefaultMenuService implements MenuService {
	
	private MenuDao menuDao;
	
	public DefaultMenuService() {
		menuDao = new JdbcMenuDao(); //스프링 이용할 때는 new 안씀.
									// 매개변수로 겹치는거 없으니까 this안써줘도됨
	}
	
	@Override
	public List<Menu> getList() {
		
		 List<Menu> list = menuDao.findAll();
		 return list;
	}

}

package com.newlecture.web.repository.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.newlecture.web.entity.Menu;
import com.newlecture.web.repository.MenuDao;
import com.newlecture.web.service.MenuService;

public class JdbcMenuDao implements MenuDao {
	
	

	@Override
	public List<Menu> findAll() {
		
		List<Menu> menus = new ArrayList<>();
		
		String query = "";
		String sql = String.format("select * from member where nicname like '%s'", "%"+query+"%") ;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@oracle.newlecture.com:1521/xepdb1";
			Connection con = DriverManager.getConnection(url, "NEWLEC", "rland");
			
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			
			
			// 필터링, 집계, 정렬
			while(rs.next())	// 서버의 커서를 한칸 내리고 그 위치의 레코드를 옮겨 오는 것. -> 레코드 하나가 저장되는 공간은?
			{
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String nicName = rs.getString("nicname");
				Date regDate = rs.getDate("reg_date");
				
				Menu menu = new Menu(id, name, 1000, "", regDate);
				menu.setImgs("pic1.png,pic2.png,pic3.png,pic4.png");
				menus.add(menu);
		
			}
			
			con.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return menus;
	}
	
	
	}



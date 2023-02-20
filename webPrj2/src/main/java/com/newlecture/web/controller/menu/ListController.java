package com.newlecture.web.controller.menu;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newlecture.web.service.MenuService;

@WebServlet("/menu/list")
public class ListController extends HttpServlet {
	//Service  - DB와 소통하는 시키
	//Menu 데이터를 가져오는 시키 (Controller가 데이터를 직접 가져오지 않고 Service한테 시킴)
	private MenuService  service; // service는 저 담당한테 위임한거니까 JDBC인지 뭔지는 우리 알바가 아님 즉, MenuService는 인터페이스
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html; charset=utf-8");		
		PrintWriter out = resp.getWriter();
		out.print("ok hello");

		
		
		
		
		//메뉴 목록을 뿌리자.
		String query = "";
		String sql = String.format("select * from member where nicname like '%s'", "%"+query+"%") ;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@oracle.newlecture.com:1521/xepdb1";
			Connection con = DriverManager.getConnection(url, "NEWLEC", "rland");
			
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			out.write("<!DOCTYPE html>");
			
			out.write("<head>");
			out.write(" <meta charset=\"UTF-8\">");
			out.write("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">");
			out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
			out.write(" <title>Document</title>");
			out.write("</head>");
			out.write("<body>");
			out.write(" <h1>메뉴 목록</h1>");
			out.write(" <table>");
			out.write(" <tr>");
			out.write("  <td>번호</td>");
			out.write(" <td>이름</td>");
			out.write(" <td>가격</td>");
			out.write(" </tr>");
			
			
			
			// 필터링, 집계, 정렬
			while(rs.next())	// 서버의 커서를 한칸 내리고 그 위치의 레코드를 옮겨 오는 것. -> 레코드 하나가 저장되는 공간은?
			{
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String nicName = rs.getString("nicname");
				
				//out.println("<table>");
				//out.println("<tr>");
				String format = String.format("id:%d, name:%s, nicname:%s\n" , id, name, nicName);
				//out.println(format);
//				out.println("</tr>");
//				out.println("</table>");
					
						
				out.write("<tr>");	
				out.write("	<td>"+name+"</td>");	
				out.write("	<td>아메리카노</td>");	
				out.write("	<td>5000</td>");				
				out.write("</tr>");	
			}
			
			con.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

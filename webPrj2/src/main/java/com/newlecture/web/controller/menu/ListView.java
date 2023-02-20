package com.newlecture.web.controller.menu;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newlecture.web.entity.GList;
import com.newlecture.web.entity.Menu;
import com.newlecture.web.entity.NList;
import com.newlecture.web.service.MenuService;

@WebServlet("/menu/listview")
public class ListView extends HttpServlet {
	//Service  - DB와 소통하는 시키
	//Menu 데이터를 가져오는 시키 (Controller가 데이터를 직접 가져오지 않고 Service한테 시킴)
	private MenuService  service; // service는 저 담당한테 위임한거니까 JDBC인지 뭔지는 우리 알바가 아님 즉, MenuService는 인터페이스
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		

		resp.setContentType("text/html; charset=utf-8");		
		PrintWriter out = resp.getWriter();
		out.print("ok hello");
	
				

		
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
		
		
		List<Menu> menus = (List<Menu>)req.getAttribute("menus2"); // Object타입을 반환하므로 형변환
		
		
		
		for(int i=0; i< menus.size(); i++ ) {
			Menu m = (Menu) menus.get(i); // menus가 Object배열이라서 형변환
			out.write("<tr>");	
			out.write("	<td>"+m.getId()+"</td>");	
			out.write("	<td>"+m.getName()+"</td>");	
			out.write("	<td>5000</td>");				
			out.write("</tr>");	
		}
	}
}

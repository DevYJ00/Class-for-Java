package com.newlecture.web.controller.menu;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
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

@WebServlet("/menu/list2")
public class ListController2 extends HttpServlet {
	
	//service, dao, 프론트컨트롤러, 컨트롤러 이런식으로 4개로 분리한당 ( 하다가 스프링으로 이동 )
	
	//Service  - DB와 소통하는 시키
	//Menu 데이터를 가져오는 온다. (Controller가 데이터를 직접 가져오지 않고 Service한테 시킴)
	private MenuService  service; // service는 저 담당한테 위임한거니까 JDBC인지 뭔지는 우리 알바가 아님 즉, MenuService는 인터페이스
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html; charset=utf-8");		
		PrintWriter out = resp.getWriter();
		out.print("ok hello");

		
//		NList menus = new NList();
//		GList<Menu> glist = new GList<Menu>();
		GList<Menu> glist = new GList<>(); //이렇게 객체 만드는 부분에서 타입 생략도 가능
		/*그런데 실제 이렇게 만들어서 사용하지는 않는다.
		왜냐면, ArrayList에서 제공하고 있으므로!
		*/
		
		/*지네릭 타입을 사용하지 않으면, List 객체에서 get( ) 반환시 Object 타입을 반환해서 형변환을 해야함.
		  하지만 지네릭타입으로 타입을 명시하면, 그 타입만 들어간게 확실하기 때문에 타입으로 반환.
		*/
		List<Menu> menus = new ArrayList<>(); // List는 인터페이스, ArrayList는 클래스
		
		
		
		//메뉴 목록을 뿌리자.
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
				
				
				
				
				
				//out.println("<table>");
				//out.println("<tr>");
			//	String format = String.format("id:%d, name:%s, nicname:%s\n" , id, name, nicName);
				//out.println(format);
//				out.println("</tr>");
//				out.println("</table>");
					
						
		
			}
			
			con.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		/* Controller와 View 의 분리로 추가된 코드 (23.02.13 월)
		   1. 리다이렉트 (클라이언트에게 새로운 url 을 리다이렉트, 클라이언트가 자동 재요청)
		   DB에서 얻은 데이터와 함께 View로 리다이렉트
		   HttpServletResponse 기본 객체가 제공하는 기능(메서드) - 리다이렉트
		*/
//		resp.sendRedirect("listview"); 
		
		/* Controller와 View 의 분리로 추가된 코드 (23.02.13 월)
		   2. 포워딩 (서버 내부에서 서버가 재요청)
		*/
		
		//"/aa/bb/menu/list2"
		req.setAttribute("menus", menus); // req객체에 menus 담아서 전달~
		req
		.getRequestDispatcher("/WEB-INF/view/menu/list.jsp") //이런 경우는 상대경로보다 절대경로
		.forward(req, resp);
		
		
		
		//--------------------------------------------------------------------------------
		
		//2. 이제 html코드랑 분리 -> JSP
		
		//1. DB연결이랑 출력부 분리 (ListController 때는 합쳐서 했고)
		
//		out.write("<!DOCTYPE html>");
//		
//		out.write("<head>");
//		out.write(" <meta charset=\"UTF-8\">");
//		out.write("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">");
//		out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
//		out.write(" <title>Document</title>");
//		out.write("</head>");
//		out.write("<body>");
//		out.write(" <h1>메뉴 목록</h1>");
//		out.write(" <table>");
//		out.write(" <tr>");
//		out.write("  <td>번호</td>");
//		out.write(" <td>이름</td>");
//		out.write(" <td>가격</td>");
//		out.write(" </tr>");
		
//		for(int i=0; i< menus.size(); i++ ) {
//			Menu m = (Menu) menus.get(i); // menus가 Object배열이라서 형변환
//			out.write("<tr>");	
//			out.write("	<td>"+m.getId()+"</td>");	
//			out.write("	<td>"+m.getName()+"</td>");	
//			out.write("	<td>5000</td>");				
//			out.write("</tr>");	
//		}
	}
}

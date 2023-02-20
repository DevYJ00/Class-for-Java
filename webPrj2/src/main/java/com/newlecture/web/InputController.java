package com.newlecture.web;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

@WebServlet("/input")
public class InputController extends HttpServlet {

	
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			req.getRequestDispatcher("/WEB-INF/view/input/input.jsp").forward(req, resp);
		}
		
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			req.setCharacterEncoding("UTF-8");
			resp.setContentType("text/html; charset=UTF-8");
			
//			String page = req.getParameter("page");
//			String query = req.getParameter("query");
//			String size = req.getParameter("size");
//			
//			req.setAttribute("page", page);
//			req.setAttribute("query", query);
//			req.setAttribute("s", s);
//			
			Enumeration<String> paramNmaes = req.getParameterNames();
			while(paramNmaes.hasMoreElements()) {
				String paramName = paramNmaes.nextElement();
				
				req.setAttribute(paramName,req.getParameter(paramName));
				System.out.println(req.getAttribute(paramName));
			}
			
			
			String[] hb = req.getParameterValues("hb");
			System.out.println(hb.length);
			req.setAttribute("hbLength", hb.length);
			
			
//			resp.getWriter().print("입력 잘 들어왔스");
			req.getRequestDispatcher("/WEB-INF/view/input/input.jsp").forward(req, resp);
			
		}
	
	
//		@Override
//		protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//			
//			 //사용자한테 입력받는데에는 5가지 방법이 존재
//			
//			/*1. 쿼리 스트링을 이용한 입력
//			 	 문서를 요청하면서 요청하는 추가 옵션 값
//				 예) 페이지, 검색어, 레코드 개수, 기간, ...
//			*/
////			String page = request.getParameter("p");
////			String q = request.getParameter("q");
////			String s = request.getParameter("s");
//			
//			//쿼리스트링 size를 입력 받기 위한 키워드를 왜 size라 안하고 s?
//			//url이 원래는 1000자 라는 길이제한이 있어서. 최근은 제한이 없다.
//			
//			String query = request.getQueryString();
//			System.out.printf(query); //
//			
//			Enumeration<String> parameterNames =request.getParameterNames();
//			
//			while(parameterNames.hasMoreElements()) {
//				String paraName = parameterNames.nextElement();
//				System.out.println(paraName + " : " + request.getParameter(paraName));
//			}
//			
////			response.getWriter().print(page);
//			
//			//2. Form을 이용한 입력
//			//사실 쿼리 스트링은 사용자가 전달하는 값이라기 보다 페이지를 제공하는 쪽에서 정해진 값을 선택하게 하는 방식
//			//예를 들어 쿼리스트링은 사용자가 URL창을 직접 편집하는 것이 아니라 다음처럼 링크에 있는 경우가 일반적이다.
//			//<a href="input?p=2q=hello&s=15">2</a>
//			//<a href="input?p=3q=hello&s=15">1</a>
//			//위와 같이 이미 정해진 값들 중 하나의 링크를 선택함으로써 입력을 요청하게 된다.
//			
//			//반면에 사용자가 값을 직접 입력하게 하고 싶다면? form엘 제공함으로써 입력하게 한다.
//			/*
//			 	<form>
//			 		<label> page : </label>
//			 		<input type="text" name="p"> 이런식으로...
//			 */
//			
//			
//			//3. 쿠키 입력
//			//4. Header 입력
//			//5. hidden 필드 입력
//			
//		}
}

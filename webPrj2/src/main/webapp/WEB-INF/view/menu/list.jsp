<%@page import="com.newlecture.web.entity.Menu"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<%!

public int add(int x, int y) {
	return x+y;
}

%>


<%-- List<Menu> menus = (List<Menu>)request.getAttribute("menus"); --%> 

<c:set var="path" value="/webprj"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>메뉴 목록</h1>
	<table border="1">
		<tr>
			<td>번호</td>
			<td>이름</td>
			<td>가격</td>	
			<td>등록일</td>				
		</tr>
		<c:forEach var="m" items="${menus}">
			<fmt:formatNumber pattern="#,###" var="price" value="${m.price}"/>
			<fmt:formatDate pattern="yy년 MM월 dd일 E요일 a h시  m분 s초"  var="regDate" value="${m.regDate }"/>
			
		
				<tr>
					<td>${m.id}</td>
					<td>${m.name}</td>
					<td>${price}</td>
					<td>${regDate}</td>
				</tr>
				<tr>	
						<td colspan="4">
							<c:forTokens varStatus="st"  var="img" items="${m.imgs}" delims="," >
								<a download href="upload/${img}">${img} 
									<c:if test="${!st.last }">|</c:if>
								</a>
							</c:forTokens>
						</td>
				</tr>
				
<%--
		<td><fmt:formatNumber pattern="#,###" value="${m.price}"/></td>
		<td><fmt:formatDate pattern="yy년 MM월 dd일 E요일 a h시  m분 s초" value="${m.regDate }"/></td>
		<td>${m.regDate}</td>	
			<td><%= menu.getId() %></td>
			<td><%= menu.getName() %></td>
			<td><%= menu.getPrice() %></td>		
 --%>	
			
		</c:forEach>	
	</table>

</body>
</html>
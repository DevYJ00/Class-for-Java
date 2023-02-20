<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<c:set var="size" value="1000" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 직접 form 태그값 입력하는 경우  -->
	<form action="/input" method="post" >
		<label for="page">page입력:
			<input type="text" name="page">
		</label>
		<label for="query">검색어 입력:
			<input type="text" name="query">
		</label>
		<label for="size">size 입력:
			<input type="text" name="size">
		</label>
		<input type="submit" value="전송">
	</form>
	<div>
		header : ${header["User-Agent"]} <br>
		param size : ${param.s}<br>
		header 유입경로 : ${header.referer } <br>
		취미 갯수 : ${hbLength }<br>
	</div>
	
	
	<form action="/input" method="post" >
		<fildset>
		<legend>취미</legend>
		<input type="checkbox" name="hb" value="1">
		<label>탁구</label>
		<input type="checkbox" name="hb" value="2">
		<label>독서</label>
		<input type="checkbox" name="hb" value="3">
		<label>슬</label>
		<input type="submit" value="전송">
	</fildset>
	</form>
	
		
	
	<!-- 선택으로 form  입력하는 경우  -->
	<a href="input?p=2&q=hello&s=15">2</a>
	<a href="input?p=2&q=hello&s=15">1</a>
	
	<!--  들어온 값 출력 , 페이지 새로만들기 귀찮으니꼐 -->
	<div>
		page : ${page}, query : ${query}, size : ${requestScope.size}
	
	</div>
</body>
</html>
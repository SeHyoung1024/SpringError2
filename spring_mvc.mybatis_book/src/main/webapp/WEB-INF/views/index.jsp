<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>도서 관리 시스템</h4>
	<br>
	
	<a href="<c:url value='/book/listAllBook'/>">전체 도서 조회</a> <br>
	<a href="<c:url value='/book/newBookForm'/>">도서 등록</a> <br>
	
	<h3>Ajax 연습</h3>
	<a href="<c:url value='loginForm'/>">[로그인]</a> <br> 
	<a href="<c:url value='loginForm2'/>">[로그인]</a> <br> 
	
	<h3>상품 검색</h3>
	<a href="<c:url value='/book/productSearchForm1'/>">[]상품 검색 1]</a> <br>
</body>
</html>
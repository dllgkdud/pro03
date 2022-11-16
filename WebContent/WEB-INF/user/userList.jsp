<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.*, java.lang.*" %>
<%@ page import="java.text.*, java.net.InetAddress" %>
<c:set var="path1" value="<%=request.getContextPath() %>" />    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보</title>
<!-- css -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.4/css/bulma.min.css">
<!-- font -->
<link href="https://webfontworld.github.io/SCoreDream/SCoreDream.css" rel="stylesheet">
<!-- jquery -->
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
</head>
<style>
abbr {
	text-decoration: none;
}
</style>
<body>
<jsp:include page="/header.jsp" />
	<section class="section">
	    <div class="columns is-full">
	    	<div class="column is-10">
				<h1 class="title">회원목록</h1>
				<table class="table">
					<thead>
					    <tr>
					      <th><abbr title="No">No</abbr></th>
					      <th><abbr title="Id">Id</abbr></th>
					      <th><abbr title="Name">Name</abbr></th>
					      <th><abbr title="RegDate">RegDate</abbr></th>
					    </tr>
					</thead>
					<tbody>
				   	<c:forEach items="${list }" var="dto" varStatus="no">
					    <tr>
					      <td>${no.count }</td>
					      <td><a href="${path1 }/GetUserDetailCtrl.do?id=${dto.id }">${dto.id }</a></td>
					      <td><a href="${path1 }/GetUserDetailCtrl.do?id=${dto.id }">${dto.name }</a></td>
					      <td>
					      	<fmt:parseDate value="${dto.regdate }" var="reg" pattern="yyyy-MM-dd HH:mm:ss" />
					      	<fmt:formatDate value="${reg }" pattern="yyyy-MM-dd" />
					    </tr>
					</c:forEach>
					<c:if test="${empty list }">
					    <tr>
					    	<td colspan="4">회원목록이 존재하지 않습니다.</td>
					    </tr>
			    	</c:if>
				  	</tbody>
				</table>
			</div>
		</div>
  </section>
<jsp:include page="/footer.jsp" />
</body>
</html>
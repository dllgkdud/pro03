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
<title>공지사항</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.4/css/bulma.min.css">
</head>
<body>
	<jsp:include page="/header.jsp" />
	<section class="section">
		<div class="container">
			<h1 class="title">공지사항 상세</h1>
			<table class="table">
				<tbody>  
					<tr>
						<th>번호</th>
						<td>
							<span>${dto.no }</span>
						</td>
					</tr>
					<tr>
						<th>제목</th>
						<td>${dto.title }</td>
					</tr>
					<tr>
						<th>내용</th>
						<td>${dto.content }</td>
					</tr>
					<tr>
						<th>작성일</th>
						<td>
							<fmt:parseDate value="${dto.regDate }" var="regdate" pattern="yyyy-MM-dd" />
							<fmt:formatDate value="${regdate }" pattern="yyyy-MM-dd" />
						</td>
					</tr>
					<tr>
						<th>조회수</th>
						<td>${dto.visited }</td>
					</tr>
				</tbody>
			</table>
			<div class="buttons">
				<a href="${path1 }/GetNoticeListCtrl.do" class="button is-light">목록</a>
				<a href="${path1 }/DeleteNoticeCtrl.do?no=${dto.no }" class="button is-primary">삭제</a>
				<a href="${path1 }/UpdateNoticeCtrl.do?no=${dto.no }" class="button is-primary">수정</a>
			</div>
		</div>
	</section>
	<jsp:include page="/footer.jsp" />
</body>
</html>
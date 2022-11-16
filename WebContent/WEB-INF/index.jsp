<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.*, java.lang.*" %>
<%@ page import="java.text.*, java.net.InetAddress" %>  
<c:set var="path1" value="${request.contextPath }" />  
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>문화관광</title>
	<!-- css -->
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.4/css/bulma.min.css">
	<!-- font -->
	<link href="https://webfontworld.github.io/SCoreDream/SCoreDream.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="${path1 }/header.jsp" />

	<jsp:include page="${path1 }/footer.jsp" />	
</body>
</html>
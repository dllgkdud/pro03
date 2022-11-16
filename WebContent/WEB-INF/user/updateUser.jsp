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
<body>
<jsp:include page="/header.jsp" />
	<form name="frm" id="frm" action="${path1 }/UpdateUserCtrl.do" method="post" onsubmit="return joinCheck(this)">
		<table class="table">
			<tbody>
				<tr>
					<th>아이디</th>
					<td>
						<div class="form-row">
							<input type="text" name="id" id="id" placeholder="아이디 입력" value="${dto.id }" class="input" readonly required />
						</div>
					</td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="pw" id="pw" placeholder="비밀번호 입력" value="${dto.pw }" class="input" required /></td>
				</tr>
				<tr>
					<th>비밀번호 확인</th>
					<td><input type="password" name="pw2" id="pw2" placeholder="비밀번호 확인" value="${dto.pw }" class="input" required /></td>
				</tr>
				<tr>
					<th>이름</th>
					<td><input type="text" name="name" id="name" placeholder="이름 입력" value="${dto.name }" class="input" required /></td>
				</tr>
				<tr>
					<th>연락처</th>
					<td><input type="tel" name="tel" id="tel" placeholder="전화번호 숫자만 입력(XXXXXXXXXXX)" class="input" value="${dto.tel }" required></td>
				</tr>
				<tr>
					<th>생년월일</th>
					<td>
		      			<fmt:parseDate value="${dto.birth }" var="bir" pattern="yyyy-MM-dd" />
		      			<fmt:formatDate value="${bir }" var="birth" pattern="yyyy-MM-dd" />
						<input type="date" name="birth" id="birth" placeholder="생년월일 입력" value="${birth }" class="input" required>
					</td>
				</tr>
				<tr>
					<th>이메일</th>
					<td><input type="email" name="email" id="email" placeholder="이메일 입력" value="${dto.email }" class="input" required></td>
				</tr>
				<tr>
					<th>주소</th>
					<td>
						<h3>${dto.addr }</h3>
						<input type="hidden" name="addr" id="addr" value="${dto.addr }" />
						<h3><strong>변경 시에만 입력하십시오.</strong></h3>
						<input type="text" name="addr1" id="addr1" placeholder="기본 주소 입력" class="input" required /><br>
						<input type="text" name="addr2" id="addr2" placeholder="상세 주소 입력" class="input" required /><br>
						<input type="text" name="postcode" id="postcode" style="width:160px;float:left;margin-right:20px;" placeholder="우편번호" class="input">
						<button id="post_btn" onclick="findAddr()" class="button is-info">우편번호 검색</button>
					</td>
				</tr>
				<tr>
					<th>회원등급</th>
					<td>
						<c:set var="grade" value="${dto.grade }" /> 
						<c:if test="${grade eq 'A' }">
						<span>VIP</span>
						</c:if>
						<c:if test="${grade eq 'B' }">
						<span>우수회원</span>
						</c:if>
						<c:if test="${grade eq 'C' }">
						<span>성실회원</span>
						</c:if>
						<c:if test="${grade eq 'D' }">
						<span>일반회원</span>
						</c:if>
						<c:if test="${grade eq 'F' }">
						<span>예비회원</span>
						</c:if>
						<c:if test="${grade eq 'M' }">
						<span>관리자</span>
						</c:if>
						<input type="hidden" name="grade" id="grade" value="${grade }" />	
					</td>
				</tr>
				<tr>
					<th>방문 횟수</th>
					<td>${dto.visited }</td>
				</tr>
				<tr>
					<th>가입일</th>
					<td>${dto.regdate }</td>
				</tr>				
			</tbody>
		</table>
		<div class="btn-group">
			<a href="${path1 }" class="button is-light">취소</a>		
			<input type="submit" name="submit-btn" class="button is-primary" value="회원정보변경">
		</div>
	</form>	
	<script>
	function joinCheck(f){
		if(f.pw.value!=f.pw2.value){
			alert("비밀번호가 일치하지 않습니다.");
			f.pw.focus();
			return false;
		}
		if(f.idck.value!="yes"){
			alert("아이디 중복 체크를 진행하십시오.");
			return false;
		}
	}
	</script>
	<script>
	function findAddr() {
		new daum.Postcode({
			oncomplete: function(data) {
				console.log(data);
				var roadAddr = data.roadAddress;
				var jibunAddr = data.jibunAddress;
				document.getElementById("postcode").value = data.zonecode;
				if(roadAddr !== '') {
					document.getElementById("addr1").value = roadAddr;				
				} else if(jibunAddr !== ''){
					document.getElementById("addr1").value = jibunAddr;
				}
				document.getElementById("addr2").focus();
			}
		}).open();
	}
	</script>
	<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<jsp:include page="/footer.jsp" />
</body>
</html>
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
<title>회원가입</title>
<!-- css -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.4/css/bulma.min.css">
<!-- font -->
<link href="https://webfontworld.github.io/SCoreDream/SCoreDream.css" rel="stylesheet">
<!-- jquery -->
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
</head>
<style>
#msg {
	padding-left: 0.5rem;
	font-size: 14px;
}
</style>
<body>
<jsp:include page="/header.jsp" />
	<section class="section">
	    <div class="container">
			<h2 class="title">회원가입</h2>
			<form name="frm" id="frm" action="${path1 }/AddUserCtrl.do" method="post" onsubmit="return joinCheck(this)">
				<table class="table">
					<tbody>
						<tr>
							<th>아이디</th>
							<td>
								<div class="form-row">
									<input type="text" name="id" id="id" class="input is-info" style="width:160px;float:left;margin-right:20px;" 
									placeholder="아이디 입력" autofocus required />
									<input type="button" class="button is-info" onclick="idCheck()" value="아이디 중복 체크">
									<input type="hidden" name="idck" id="idck" value="no">
								</div>
								<div>
									<c:if test="${empty aid }">
										<p id="msg">아이디 중복 체크를 진행하십시오.</p>
									</c:if>
									<c:if test="${not empty aid }">
										<p id="msg">한 번 더 중복체크를 진행하십시오.</p>
									</c:if>
								</div>
							</td>
						</tr>
						<tr>
							<th>비밀번호</th>
							<td><input type="password" name="pw" id="pw" placeholder="비밀번호 입력" class="input is-info" required /></td>
						</tr>
						<tr>
							<th>비밀번호 확인</th>
							<td><input type="password" name="pw2" id="pw2" placeholder="비밀번호 확인" class="input is-info" required /></td>
						</tr>
						<tr>
							<th>이름</th>
							<td><input type="text" name="name" id="name" placeholder="이름 입력" class="input is-info" required /></td>
						</tr>
						<tr>
							<th>생년월일</th>
							<td><input type="date" name="birth" id="birth" placeholder="생년월일 입력" class="input is-info" required></td>
						</tr>
						<tr>
							<th>연락처</th>
							<td><input type="tel" name="tel" id="tel" maxlength="11" placeholder="전화번호 숫자만 입력(XXXXXXXXXXX)" 
							class="input is-info" required></td>
						</tr>
						<tr>
							<th>이메일</th>
							<td><input type="email" name="email" id="email" placeholder="이메일 입력" class="input is-info" required></td>
						</tr>
						<tr>
							<th>주소</th>
							<td>
								<input type="text" name="addr1" id="addr1" placeholder="기본 주소 입력" class="input" required /><br>
								<input type="text" name="addr2" id="addr2" placeholder="상세 주소 입력" class="input" required /><br>
								<input type="text" name="postcode" id="postcode" style="width:160px;float:left;margin-right:20px;" 
								placeholder="우편번호" class="input">
								<button id="post_btn" onclick="findAddr()" class="button is-info">우편번호 검색</button>
							</td>
						</tr>
					</tbody>
				</table>
				<div class="btn-group">
					<input type="submit" name="submit-btn" class="button button-info" value="회원가입">
					<input type="reset" name="reset-btn" class="button button-info" value="취소">
					<a href="<%=request.getContextPath() %>/user/userLogin.jsp" class="button is-primary">로그인</a>
				</div>
			</form>	
			<script>
			$(document).ready(function(){
				$("#id").keyup(function(){
					$("#idck").val("no");
					if($(this).val()!=""){
						$("#msg").html("아이디 입력중입니다...");
					} else {
						$("#msg").html("아이디 중복 체크를 진행하십시오.");
					}
				});
			});
			</script>
			<script>
			function idCheck(){
				if($("#id").val()==""){
					alert("아이디를 입력해 주십시오.");
					$("#id").focus();
					return;
				} 
				var params = {	id : $("#id").val()	}	//전송되어질 데이터를 객체로 묶음
				$.ajax({
					url:"${path1 }/IdCheckCtrl.do",		//아이디가 전송되어질 곳
					type:"post",										//전송방식
					dataType:"json",								//데이터 반환 방식
					data:params,									//전송방식이 post인 경우 객체로 묶어서 전송
					success:function(result){
						console.log(result.result);
						var idChk = result.result;			//boolean을 적용해 true/false를 받음
						if(idChk==false){						//사용할 수 없는 아이디
							$("#idck").val("no");
							$("#msg").html("<strong style='color:red'>이미 사용 중인 아이디 입니다.</strong>");
							$("#id").focus();
						} else if(idChk==true){			//사용 가능한 아이디
							$("#idck").val("yes");
							$("#msg").html("<strong style='color:blue'>사용 가능한 아이디 입니다.</strong>");
						} else if(idck==""){
							$("#msg").html("<strong>아이디가 확인되지 않았습니다.</strong>");
						}
					}
				});
			}
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
		</div>
	</section>
<%@ include file="/footer.jsp" %>
</body>
</html>
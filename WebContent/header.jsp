<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<style>
.navbar-item img {
	max-height: none;
}
</style>
<nav class="navbar" role="navigation" aria-label="main navigation">
	<div class="navbar-brand">
		<a class="navbar-item" href="<%=request.getContextPath() %>/">
		<img src="	https://www.ddm.go.kr/common/images/layout/logo_bi_s2022.png" width="144" height="72">
		</a>

	<a role="button" class="navbar-burger" aria-label="menu" aria-expanded="false" data-target="navbarBasicExample">
		<span aria-hidden="true"></span>
		<span aria-hidden="true"></span>
		<span aria-hidden="true"></span>
	</a>
	</div>

	<div class="navbar-start" id="gnb">
		<div class="navbar-item has-dropdown is-hoverable" id="cate1">
		  <a class="navbar-link is-arrowless">테마관광</a>
		  <div class="navbar-dropdown">
		    <a class="navbar-item">제기동 골목이야기</a>
		    <a class="navbar-item">도심 속 산책길</a>
		    <a class="navbar-item">홍릉 이야기</a>
		    <a class="navbar-item">풍물 기행</a>
		    <a class="navbar-item">추억 나들이</a>
		    <a class="navbar-item">중랑천 강길여행</a>
		  </div>
		</div>
		<div class="navbar-item has-dropdown is-hoverable" id="cate2">
		  <a class="navbar-link is-arrowless">축제와 문화</a>
		  <div class="navbar-dropdown">
		    <a class="navbar-item">축제</a>
		    <a class="navbar-item">문화</a>
		    <div class="navbar-item">시설</div>
		  </div>
		</div>
		<div class="navbar-item has-dropdown is-hoverable" id="cate3">
		  <a class="navbar-link is-arrowless">문화재와 역사</a>
		  <div class="navbar-dropdown">
		    <a class="navbar-item">문화재</a>
		    <a class="navbar-item">현충시설</a>
		    <a class="navbar-item">동대문의 옛 이야기/인물</a>
		    <div class="navbar-item">동대문의 동명유래</div>
		  </div>
		</div>
		<div class="navbar-item has-dropdown is-hoverable" id="cate4">
		  <a class="navbar-link is-arrowless">관광과 명소</a>
		  <div class="navbar-dropdown">
		    <a class="navbar-item">VR 투어</a>
		    <a class="navbar-item">명소</a>
		    <a class="navbar-item">쇼핑</a>
		    <div class="navbar-item">식도락</div>
		    <div class="navbar-item">숙박</div>
		  </div>
		</div>
		<div class="navbar-item has-dropdown is-hoverable" id="cate5">
		  <a class="navbar-link is-arrowless">참여마당</a>
		  <div class="navbar-dropdown">
			<a class="navbar-item" href="<%=request.getContextPath() %>/GetNoticeListCtrl.do">공지사항</a>
		    <a class="navbar-item">e-관광안내소</a>
		    <a class="navbar-item">여행후기</a>
		    <div class="navbar-item">촬영신청 안내</div>
		  </div>
		</div>
	</div>

    <div class="navbar-end">
      <div class="navbar-item">
      	<c:if test="${empty sid }">
	        <div class="buttons">
	          <a class="button is-primary" href="<%=request.getContextPath() %>/user/userAgree.jsp"><strong>회원가입</strong></a>
	          <a class="button is-light" href="<%=request.getContextPath() %>/UserLoginCtrl.do">로그인</a>
	        </div>
        </c:if>
        <c:if test="${not empty sid }">
			<div class="buttons">
				<a class="button is-primary" href="<%=request.getContextPath() %>/UserInfoCtrl.do"><strong>회원정보</strong></a>
				<a class="button is-light" href="<%=request.getContextPath() %>/UserLogoutCtrl.do">로그아웃</a>
				<c:if test='${sid.equals("admin") }'>
					<a class="button is-light" href="<%=request.getContextPath() %>/AdminCtrl.do">관리자</a>
				</c:if>
	        </div>
        </c:if>
      </div>
    </div>
</nav>
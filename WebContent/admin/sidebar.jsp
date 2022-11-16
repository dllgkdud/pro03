<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.*, java.lang.*" %>
<%@ page import="java.text.*, java.net.InetAddress" %>
<c:set var="path1" value="<%=request.getContextPath() %>" />
<aside class="menu">
	<p class="menu-label">
		General
	</p>
	<ul class="menu-list">
		<li><a href="${path1 }/GetUserListCtrl.do" class="navbar-item">회원관리</a></li>
		<li><a href="${path1 }/AddTourCtrl.do" class="navbar-item">투어관리</a></li>
	</ul>
	<p class="menu-label">
		Administration
	</p>
	<ul class="menu-list">
		<li><a>Team Settings</a></li>
		<li>
			<a class="is-active">Manage Your Team</a>
			<ul>
				<li><a>Members</a></li>
	        	<li><a>Plugins</a></li>
	        	<li><a>Add a member</a></li>
			</ul>
		</li>
	    <li><a>Invitations</a></li>
	    <li><a>Cloud Storage Environment Settings</a></li>
	    <li><a>Authentication</a></li>
	</ul>
	<p class="menu-label">
		Transactions
	</p>
	<ul class="menu-list">
		<li><a>Payments</a></li>
	    <li><a>Transfers</a></li>
	    <li><a>Balance</a></li>
	  </ul>
</aside>
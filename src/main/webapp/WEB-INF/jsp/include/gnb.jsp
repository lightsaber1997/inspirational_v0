<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<nav class="navbar navbar-expand-lg bg-light">
	<div class="container-fluid">
		<a class="navbar-brand" href="/">Inspirational</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<sec:authorize access="isAnonymous()">
			<a class="btn btn-light" href="/user/sign_in_view">로그인</a>
		</sec:authorize>

		<sec:authorize access="hasAuthority('student')">
			<sec:authentication property="principal" var="principal"/>
		
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link" aria-current="page"
						href="#">선생님 목록</a></li>
					<li class="nav-item"><a class="nav-link" href="#">수업 목록</a></li>
					<li class="nav-item"><a class="nav-link" href="/lesson_request/">수업 요청하기</a></li>
					<li class="nav-item"><a class="nav-link" href="#">결제</a></li>
					<li class="nav-item"><a class="nav-link" href="#">메시지</a></li>
					<li class="nav-item"><a class="nav-link" href="/user/profile/${principal.username}">내 프로필</a></li>
				</ul>
				<button class="button-64" id="btn_logout" role="button"><span class="text">로그아웃</span></button>
			 
			</div>
			
			
			
		</sec:authorize>

		
	</div>
</nav>
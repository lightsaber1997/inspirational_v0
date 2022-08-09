<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<form method="POST" id="signin-form" class="signin-form">
	<h2 class="form-title">Sign In</h2>
	<div class="form-group">
		<input type="text" class="form-input" name="username" id="username"
			placeholder="아이디" />
	</div>


	<div class="form-group">
		<input type="password" class="form-input" name="password"
			id="password" placeholder="비밀번호" />
	</div>


	<div class="form-group">
		<input type="submit" name="submit" id="submit" class="form-submit"
			value="Sign In" />
	</div>
</form>
<p class="loginhere">
	계정이 없으신가요 ? <a href="/user/sign_up_view" class="loginhere-link">회원가입 하기</a>
</p>

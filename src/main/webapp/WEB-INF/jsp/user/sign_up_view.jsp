<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<form method="POST" id="signup-form" class="signup-form">
	<h2 class="form-title">Create account</h2>
	<div class="form-group">
		<input type="text" class="form-input" name="loginId" id="loginId"
			placeholder="로그인 아이디" />
	</div>
	<div class="form-group">
		<input type="email" class="form-input" name="email" id="email"
			placeholder="이메일 주소" />
	</div>
	<div class="form-group">
		<input type="text" class="form-input" name="password" id="password"
			placeholder="비밀번호" /> <span
			toggle="#password" class="zmdi zmdi-eye field-icon toggle-password"></span>
	</div>
	<div class="form-group">
		<input type="password" class="form-input" name="re_password"
			id="re_password" placeholder="비밀번호를 재입력해주세요" />
	</div>
	<div class="form-group">
		<input type="text" class="form-input" name="realName" id="realName"
			placeholder="이름" />
	</div>
	<div class="form-group">
		<input type="text" class="form-input" name="phoneNumber"
			id="phoneNumber" placeholder="전화번호" />
	</div>
	<div class="form-group">
		<input type="text" class="form-input" name="userNameInApp"
			id="userNameInApp" placeholder="사이트에서 사용할 유저네임" />
	</div>
	<div class="form-group">
		<input type="checkbox" name="agree-term" id="agree-term"
			class="agree-term" /> <label
			for="agree-term" class="label-agree-term"><span><span></span></span>I
			agree all statements in <a href="#" class="term-service">Terms
				of service</a></label>
	</div>
	<div class="form-group">
		<input type="submit" name="submit" id="submit" class="form-submit"
			value="Sign up" />
	</div>
</form>
<p class="loginhere">
	Have already an account ? <a href="#" class="loginhere-link">Login
		here</a>
</p>

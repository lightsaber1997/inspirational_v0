<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<meta name="_csrf" content="${_csrf.token}">
<meta name="_csrf_header" content="${_csrf.headerName}">
</head>
<body>
	<input name="loginId" type="text">
	<input name="password" type="password">
	<button id="submit_btn">Submit</button>
	
</body>
<script>
$(document).ready(function() {
	
	$("#submit_btn").on("click", function() {
		let loginId = $("input[name=loginId]").val();
		let password = $("input[name=password]").val();
		
		let csrf_token  = $("meta[name='_csrf']").attr("content");
		let csrf_header = $("meta[name='_csrf_header']").attr("content");
		
		$.ajax({
			url: "/user/sign_in",
			method: "POST",
			beforeSend: function(request) {
				request.setRequestHeader(csrf_header, csrf_token);
			},
			data: {"username": loginId, "password": password},
			success: function(data) {
				console.log(data);
			}
		});
	});

});
</script>
</html>
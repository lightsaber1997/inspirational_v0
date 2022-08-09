<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <meta http-equiv="X-UA-Compatible" content="ie=edge" />
        <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
        <title>Sign Up Form by Colorlib</title>
		<meta name="_csrf" content="${_csrf.token}">
		<meta name="_csrf_header" content="${_csrf.headerName}">
        <!-- Font Icon -->
        <link
            rel="stylesheet"
            href="fonts/material-icon/css/material-design-iconic-font.min.css"
        />

        <!-- Main css -->
        <link rel="stylesheet" href="${mainCss}" />
    </head>
    <body>
        <div class="main">
            <section class="signup">
                <!-- <img src="images/signup-bg.jpg" alt=""> -->
                <div class="container">
                    <div class="signup-content">
                    	<jsp:include page="../${viewName}.jsp"/>
                    </div>
                </div>
            </section>
        </div>

        <!-- JS -->
        
        <script>
	$(document).ready(function() {
		$("#signup-form").on("submit", function(e) {
			e.preventDefault();
			//console.log($(this).serialize());
			
			let loginId = $("#loginId").val();
			let password = $("#password").val();
			let email = $("#email").val();
			let phoneNumber = $("#phoneNumber").val();
			let userNameInApp = $("#userNameInApp").val();
			let realName = $("#realName").val();
			let csrf_token  = $("meta[name='_csrf']").attr("content");
			let csrf_header = $("meta[name='_csrf_header']").attr("content");
			
			$.ajax({
				url: "/user/sign_up",
				method: "POST",
				beforeSend: function(request) {
					request.setRequestHeader(csrf_header, csrf_token);
				},
				data: {
					"loginId": loginId,
					"password": password,
					"email": email,
					"phoneNumber": phoneNumber,
					"authority": "student",
					"userNameInApp": userNameInApp,
					"realName": realName
				},
				success: function(data) {
					console.log(data);
					if (data["success"] == true) {
						location.href = "/user/sign_in_view";
					}
				}
			});
		});
		$("#signin-form").on("submit", function(e) {
			e.preventDefault();
			// console.log("signin");
			
			let username = $("#username").val();
			let password = $("#password").val();
			
			let csrf_token  = $("meta[name='_csrf']").attr("content");
			let csrf_header = $("meta[name='_csrf_header']").attr("content");
			
			$.ajax({
				url: "/user/sign_in",
				method: "POST",
				beforeSend: function(request) {
					request.setRequestHeader(csrf_header, csrf_token);
				},
				data: {
					"username": username,
					"password": password,
				},
				statusCode: {
					200: function(response) {
						location.href = "/";
					},
					201: function(response) {
					location.href = "/";
					}
				},
				success: function(data) {
					console.log(data);
					if (data["success"] == true) {
						location.href = "/";
					}
				}
			});
		});
	});
	</script>
    </body>
    <!-- This templates was made by Colorlib (https://colorlib.com) -->
	
</html>
    
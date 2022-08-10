<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.js"
	integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
	crossorigin="anonymous"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
	crossorigin="anonymous">


<script src="https://cdn.jsdelivr.net/npm/ola"></script>

<link rel="stylesheet" type="text/css" href="${css_file}">
<link rel="stylesheet" type="text/css" href="/static/css/template/layout.css">


<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Tangerine:wght@700&display=swap" rel="stylesheet">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap" rel="stylesheet">

<meta name="_csrf" content="${_csrf.token}">
<meta name="_csrf_header" content="${_csrf.headerName}">

</head>
<body>
	<div id="wrap">
		<header class="bg-info">
			<jsp:include page="../include/gnb.jsp"/>
		</header>
		<section class="content">
			<jsp:include page="../${viewName}.jsp"/>
		</section>
		<footer class="bg-danger">
			<jsp:include page="../include/footer.jsp"/>
		</footer>
	</div>
	
	
	
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
		crossorigin="anonymous"></script>
	
<script>
$(document).ready(function() {
	$("#btn_logout").on("click", function() {
		let csrf_token  = $("meta[name='_csrf']").attr("content");
		let csrf_header = $("meta[name='_csrf_header']").attr("content");
		$.ajax({
			url: "/user/logout",
			method: "POST",
			beforeSend: function(request) {
				request.setRequestHeader(csrf_header, csrf_token);
			},
			success: function(data) {
				if (data["success"] == true) {
					location.href = "/";
				}
			}
		});
	});
});
</script>
</body>
</html>
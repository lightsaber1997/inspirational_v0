<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.min.js"
	type="text/javascript"></script>
<div class="d-flex justify-content-center">
	<div class="col-8">
		<div>레슨 요청하기</div>
		<select id="phone_number_access" class="form-select" aria-label="Default select example">
			<option selected>전화 번호 공개 여부</option>
			<option value="1">공개</option>
			<option value="0">비공개</option>
		</select>
		<div>하고 싶은 말</div>

		<div>과목 선택</div>



		<c:set var="sizeListSubject" value="${fn:length(listSubject)}" />
		<c:forEach var="i" begin="0" end="${sizeListSubject-1}">
			<div>
				<div class="form-check">
					<input class="form-check-input" type="checkbox" value="${listSubject[i].id}" name="checkbox_subject"
						id="flexCheckDefault"> <label class="form-check-label"
						for="flexCheckDefault"> ${listSubject[i].subjectName} </label>
				</div>
			</div>
			<p></p>
		</c:forEach>



		<textarea id="request_main_content"></textarea>

		<button class="btn btn-outline-secondary" id="btn_delete_all_content">모두
			지우기</button>

		<div>
			<button class="btn btn-info" id="btn_submit">제출하기</button>
		</div>

	</div>
</div>

<script>
$(document).ready(function() {
	$("#btn_submit").on("click", function() {
		let phone_number_access = $("#phone_number_access").val();
		
		// console.log(phone_number_access);
		
		let checkbox_subject = $("input[name='checkbox_subject']");
		let checkbox_subject_values = $("input[name='checkbox_subject']:checked").map(function() {
			return $(this).val();
		}).get();
		
		// console.log(checkbox_subject_values);
		
		let request_main_content = $("#request_main_content").val();
		console.log(request_main_content);
		
		let csrf_token  = $("meta[name='_csrf']").attr("content");
		let csrf_header = $("meta[name='_csrf_header']").attr("content");
		
		
		$.ajax({
			url: "/lesson_request/create",
			method: "POST",
			beforeSend: function(request) {
				request.setRequestHeader(csrf_header, csrf_token);
			},
			traditional: true,
			data: {
				"usePhoneNumber": phone_number_access,
				"subjectIdList": checkbox_subject_values,
				"mainContent": request_main_content
			},
			success: function(data) {
				console.log(checkbox_subject_values);
				if (data["success"] == true) {
					//location.href = "/user/sign_in_view";
				}
			}
		});
	});
});

</script>


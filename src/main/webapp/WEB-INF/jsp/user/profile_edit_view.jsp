<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<div class="d-flex justify-content-center">
	<div class="col-8">
		<div class="edit_profile_title">Edit Profile</div>
		<div>
			<div>자기 소개 또는 선생님께 하고 싶은 말</div>
			<textarea placeholder="하고 싶은 말을 입력해 주세요." id="profile_content" name="text" rows="4" style="overflow: hidden; word-wrap: break-word; resize: none; height: 500px; ">${studentProfile.content}</textarea>  
		</div>
		<button class="btn btn-outline-secondary" id="btn_delete_all_content">모두 지우기</button>
		<button class="btn btn-info" id="btn_submit_change_content">저장</button>
	</div>
</div>



<script>
$(document).ready(function() {
	$("#btn_submit_change_content").on("click", function() {
		let content = $("#profile_content").val();
		// alert(content);
		let csrf_token  = $("meta[name='_csrf']").attr("content");
		let csrf_header = $("meta[name='_csrf_header']").attr("content");
		
		$.ajax({
			url: "/user/student/profile/update",
			method: "POST",
			beforeSend: function(request) {
				request.setRequestHeader(csrf_header, csrf_token);
			},
			data: {
				"content": content
			},
			success: function(data) {
				if (data["success"]) {
					location.href = "/user/profile";
				}
			}
		});
	});
	
	$("#btn_delete_all_content").on("click", function() {
		$("#profile_content").val("");
	});
});
</script>
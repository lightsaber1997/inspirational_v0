<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<div class="d-flex justify-content-center">
	<div class="col-8">
		<div class="full-withradius border mt-3">
			<div id="username_cursive">${profile_user.userNameInApp}</div>
			<div class="profile-info">유저네임 ${profile_user.userNameInApp}</div>

			<c:if test="${can_edit}">
			
				<div id="div_edit">
				프로필 편집하기 
				<img class="edit_img" src="/static/images/icons/edit.png">
				</div>
			</c:if>
		</div>
		
		<div class="my-5">
			<div>
				<div>자기소개 및 선생님께 한마디</div>
				<div>
				${studentProfile.content}
				</div>
			</div>
			
			<div>
			</div>
		</div>
	
	</div>
	
	
</div>
<script>
$(document).ready(function() {
	$(".edit_img").on("click", function() {
		location.href = "/user/profile/edit_view";
	});
	
});
</script>

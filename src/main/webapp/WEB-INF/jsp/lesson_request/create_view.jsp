<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.min.js"
	type="text/javascript"></script>
<div class="d-flex justify-content-center">
	<div class="col-8">
		<div>레슨 요청하기</div>
		<select class="form-select" aria-label="Default select example">
			<option selected>전화 번호 공개 여부</option>
			<option value="1">공개</option>
			<option value="2">비공개</option>
		</select>
		<div>하고 싶은 말</div>

		<div>과목 선택</div>

		<div class="form-check">
			<input class="form-check-input" type="checkbox" value=""
				id="flexCheckDefault"> <label class="form-check-label"
				for="flexCheckDefault"> Default checkbox </label>
		</div>
		<div class="form-check">
			<input class="form-check-input" type="checkbox" value=""
				id="flexCheckChecked"> <label
				class="form-check-label" for="flexCheckChecked"> Checked
				checkbox </label>
		</div>

		<textarea id="request_main_content"></textarea>

		<button class="btn btn-outline-secondary" id="btn_delete_all_content">모두
			지우기</button>

		<div>
			<button class="btn btn-info" id="btn_submit_change_content">제출하기</button>
		</div>

	</div>
</div>


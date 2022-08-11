package com.inspirational.lessonRequest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inspirational.userDetails.CustomUserDetails;

@RequestMapping("/lesson_request")
@RestController
public class LessonRequestRestController {
	@Autowired
	private LessonRequestBO lessonRequestBO;
	@Autowired
	private LessonRequestSubjectBO lessonRequestSubjectBO;
	
	@PostMapping("/create")
	public Map<String, Object> create(
			@RequestParam(value="mainContent", required=false) String mainContent,
			@RequestParam(value="usePhoneNumber", required=false) Integer usePhoneNumber,
			@RequestParam(value="grade", required=false) Integer gradeId,
			@RequestParam(value="locationList", required=false) List<String> locationList,
			@RequestParam(value="subjectIdList", required=false) List<String> subjectIdList,
			Authentication authentication) {
		Map<String, Object> result = new HashMap<>();
		
		try {
			CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
			int userId = userDetails.getId();
			int lessonRequestId = lessonRequestBO.insert(userId, gradeId, mainContent, usePhoneNumber);
			if (subjectIdList != null) {
				for (String subjectId_: subjectIdList) {
					int subjectId = Integer.parseInt(subjectId_);
					lessonRequestSubjectBO.insert(lessonRequestId, subjectId);
				}
			}
			result.put("success", true);
		} catch (Exception e) {
			// e.printStackTrace();
			result.put("success", false);
		}
		
		
		return result;
	}
}

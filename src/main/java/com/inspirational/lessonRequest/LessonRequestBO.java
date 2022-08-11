package com.inspirational.lessonRequest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LessonRequestBO {
	@Autowired
	private LessonRequestDAO lessonRequestDAO;
	
	public List<LessonRequest> selectAll() {
		return lessonRequestDAO.selectAll();
	}
	public LessonRequest selectById(int id) {
		return lessonRequestDAO.selectById(id);
	}
	public LessonRequest selectByStudentId(int studentId) {
		return lessonRequestDAO.selectByStudentId(studentId);
	}
	public LessonRequest selectByGradeId(Integer gradeId) {
		return lessonRequestDAO.selectByGradeId(gradeId);
	}
	public int insert(
			int studentId,
			Integer gradeId,
			String mainContent,
			Integer usePhoneNumber
			) {
		LessonRequest lessonRequest = new LessonRequest();
		lessonRequestDAO.insert(lessonRequest, studentId, gradeId, mainContent, usePhoneNumber);
		int lessonRequestId = lessonRequest.getId();
		return lessonRequestId;
	}
	public void update(
			int id,
			Integer gradeId,
			String mainContent,
			Integer usePhoneNumber
			) {
		lessonRequestDAO.update(id, gradeId, mainContent, usePhoneNumber);
	}
}

package com.inspirational.lessonRequest;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LessonRequestSubjectBO {
	@Autowired
	private LessonRequestSubjectDAO lessonRequestSubjectDAO;
	
	public List<LessonRequestSubject> selectAll() {
		return lessonRequestSubjectDAO.selectAll();
	}
	public LessonRequestSubject selectById(
			int id) {
		return lessonRequestSubjectDAO.selectById(id);
	}
	public List<LessonRequestSubject> selectByLessonRequestId(
			int lessonRequestId) {
		return lessonRequestSubjectDAO.selectByLessonRequestId(lessonRequestId);
	}
	public List<LessonRequestSubject> selectBySubjectId(
			int subjectId) {
		return lessonRequestSubjectDAO.selectBySubjectId(subjectId);
	}

	public void insert(
			int lessonRequestId,
			int subjectId) {
		lessonRequestSubjectDAO.insert(lessonRequestId, subjectId);
	}
	
	public void deleteById(
			@Param("id") int id) {
		lessonRequestSubjectDAO.deleteById(id);
	}
	
	public void deleteByLessonRequestIdAndSubjectId(
			int lessonRequestId,
			int subjectId) {
		lessonRequestSubjectDAO.deleteByLessonRequestIdAndSubjectId(
				lessonRequestId, subjectId);
	}
	
}

package com.inspirational.lessonRequest;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonRequestSubjectDAO {
	public List<LessonRequestSubject> selectAll();
	public LessonRequestSubject selectById(
			@Param("id") int id);
	public List<LessonRequestSubject> selectByLessonRequestId(
			@Param("lessonRequestId") int lessonRequestId);
	public List<LessonRequestSubject> selectBySubjectId(
			@Param("subjectId") int subjectId);
	
	public void insert(
			@Param("lessonRequestId") int lessonRequestId,
			@Param("subjectId") int subjectId);
	
	public void deleteById(
			@Param("id") int id);
	public void deleteByLessonRequestIdAndSubjectId(
			@Param("lessonRequestId") int lessonRequestId,
			@Param("subjectId") int subjectId);
	
}

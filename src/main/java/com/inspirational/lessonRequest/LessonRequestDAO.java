package com.inspirational.lessonRequest;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonRequestDAO {
	public List<LessonRequest> selectAll();

	public LessonRequest selectById(@Param("id") int id);

	public LessonRequest selectByStudentId(@Param("studentId") int studentId);

	public LessonRequest selectByGradeId(@Param("gradeId") Integer gradeId);

	public void insert(@Param("getPK") LessonRequest lessonRequest, 
			@Param("studentId") int studentId,
			@Param("gradeId") Integer gradeId, 
			@Param("mainContent") String mainContent,
			@Param("usePhoneNumber") Integer usePhoneNumber);

	public void update(@Param("id") int id, @Param("gradeId") Integer gradeId, @Param("mainContent") String mainContent,
			@Param("usePhoneNumber") Integer usePhoneNumber);
}

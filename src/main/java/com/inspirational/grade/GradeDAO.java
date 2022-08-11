package com.inspirational.grade;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GradeDAO {
	public List<Grade> selectAll();
	public Grade selectById(
			@Param("id") int id);
	public List<Grade> selectByGradeCategory1(
			@Param("gradeCategory1") String gradeCategory1);
	public List<Grade> selectByGradeCategory1AndGradeCategory2(
			@Param("gradeCategory1") String gradeCategory1,
			@Param("gradeCategory2") String gradeCategory2);
}

package com.inspirational.studentProfile;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentProfileDAO {
	public List<StudentProfile> selectAll();
	public StudentProfile selectById(
			@Param("id") int id);
	public StudentProfile selectByStudentId(
			@Param("studentId") int studentId);
	public void insert(
			@Param("studentId") int studentId,
			@Param("content") String content);
	public void updateByStudentId(
			@Param("studentId") int studentId,
			@Param("content") String content);
}

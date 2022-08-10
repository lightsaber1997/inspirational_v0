package com.inspirational.studentProfile;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class studentProfileBO {
	@Autowired
	private StudentProfileDAO studentProfileDAO;
	
	public List<StudentProfile> selectAll() {
		return studentProfileDAO.selectAll();
	}
	
	public StudentProfile selectById(int id) {
		return studentProfileDAO.selectById(id);
	}
	
	public StudentProfile selectByStudentId(int studentId) {
		return studentProfileDAO.selectByStudentId(studentId);
	}
	
	public void insert(
			int studentId,
			String content) {
		studentProfileDAO.insert(studentId, content);
	}
	
	public void updateByStudentId(
			int studentId,
			String content) {
		studentProfileDAO.updateByStudentId(studentId, content);
	}
}

package com.inspirational.grade;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GradeBO {
	@Autowired
	private GradeDAO gradeDAO;
	
	public List<Grade> selectAll() {
		return gradeDAO.selectAll();
	}
	public Grade selectById(
			int id) {
		return gradeDAO.selectById(id);
	}
	public List<Grade> selectByGradeCategory1(
			String gradeCategory1) {
		return gradeDAO.selectByGradeCategory1(gradeCategory1);
	}
	public List<Grade> selectByGradeCategory1AndGradeCategory2(
			String gradeCategory1,
			String gradeCategory2) {
		return gradeDAO.selectByGradeCategory1AndGradeCategory2(
				gradeCategory1, gradeCategory2);
	}
}

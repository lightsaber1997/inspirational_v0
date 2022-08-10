package com.inspirational.subject;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectBO {
	@Autowired
	private SubjectDAO subjectDAO;
	
	public List<Subject> selectAll() {
		return subjectDAO.selectAll();
	}
	public Subject selectById(int id) {
		return subjectDAO.selectById(id);
		
	}
	public Subject selectBySubjectName(String subjectName) {
		return subjectDAO.selectBySubjectName(subjectName);
	}
}

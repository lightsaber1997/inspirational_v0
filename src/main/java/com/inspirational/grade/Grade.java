package com.inspirational.grade;

import java.util.Date;

public class Grade {
	private int id;
	private String gradeCategory1;
	private String gradeCategory2;
	private Date createdAt;
	private Date updatedAt;

	public String getName() {
		if (this.gradeCategory2 == null) {
			return gradeCategory1;
		}
		return gradeCategory1 + " " + gradeCategory2 +"학년";
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGradeCategory1() {
		return gradeCategory1;
	}

	public void setGradeCategory1(String gradeCategory1) {
		this.gradeCategory1 = gradeCategory1;
	}

	public String getGradeCategory2() {
		return gradeCategory2;
	}

	public void setGradeCategory2(String gradeCategory2) {
		this.gradeCategory2 = gradeCategory2;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
}

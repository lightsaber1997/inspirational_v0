package com.inspirational.lessonRequest;

import java.util.Date;

public class LessonRequest {    
    private int id;
    private Integer studentId;
    private Integer gradeId;
    private String mainContent;
    private Integer usePhoneNumber;
    private Date createdAt;
    private Date updatedAt;
    
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Integer getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	public Integer getGradeId() {
		return gradeId;
	}
	public void setGradeId(Integer gradeId) {
		this.gradeId = gradeId;
	}
	public String getMainContent() {
		return mainContent;
	}
	public void setMainContent(String mainContent) {
		this.mainContent = mainContent;
	}
	public Integer getUsePhoneNumber() {
		return usePhoneNumber;
	}
	public void setUsePhoneNumber(Integer usePhoneNumber) {
		this.usePhoneNumber = usePhoneNumber;
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
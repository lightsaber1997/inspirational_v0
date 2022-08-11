package com.inspirational.lessonRequest;

import java.util.Date;

public class LessonRequestLocation {
	private int id;
	private int lessonRequestId;
	private int locationId;
	private Date createdAt;
	private Date updatedAt;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getLessonRequestId() {
		return lessonRequestId;
	}

	public void setLessonRequestId(int lessonRequestId) {
		this.lessonRequestId = lessonRequestId;
	}

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
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

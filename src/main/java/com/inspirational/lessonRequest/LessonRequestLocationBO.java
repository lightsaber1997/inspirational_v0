package com.inspirational.lessonRequest;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LessonRequestLocationBO {
	@Autowired
	private LessonRequestLocationDAO lessonRequestLocationDAO;
	
	public List<LessonRequest> selectAll() {
		return lessonRequestLocationDAO.selectAll();
	}
	public LessonRequest selectById(
			int id) {
		return lessonRequestLocationDAO.selectById(id);
	}
	public LessonRequest selectByLessonRequestId(
			int lessonRequestId) {
		return lessonRequestLocationDAO.selectByLessonRequestId(lessonRequestId);
	}
	public LessonRequest selectByLocationId(
			int locationId) {
		return lessonRequestLocationDAO.selectByLocationId(locationId);
	}
	public LessonRequest selectByLessonRequestIdAndLocationId(
			int lessonRequestId,
			int locationId) {
		return lessonRequestLocationDAO.
				selectByLessonRequestIdAndLocationId(lessonRequestId, locationId);
	}
	public void insert(
			int lessonRequestId,
			int locationId) {
		lessonRequestLocationDAO.insert(lessonRequestId, locationId);
	}
}

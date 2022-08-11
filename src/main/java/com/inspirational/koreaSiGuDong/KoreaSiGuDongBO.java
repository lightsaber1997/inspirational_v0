package com.inspirational.koreaSiGuDong;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KoreaSiGuDongBO {
	@Autowired
	private KoreaSiGuDongDAO koreaSiGuDongDAO;
	
	public List<KoreaSiGuDong> selectAll() {
		return koreaSiGuDongDAO.selectAll();
	}
	public KoreaSiGuDong selectById(
			int id) {
		return koreaSiGuDongDAO.selectById(id);
	}
	public List<KoreaSiGuDong> selectBySi(
			String si) {
		return koreaSiGuDongDAO.selectBySi(si);
	}
	public List<KoreaSiGuDong> selectBySiAndGu(
			String si,
			String gu) {
		return koreaSiGuDongDAO.selectBySiAndGu(si, gu);
	}
	public List<KoreaSiGuDong> selectBySiAndGuAndDong(
			String si,
			String gu,
			String dong) {
		return koreaSiGuDongDAO.selectBySiAndGuAndDong(si, gu, dong);
	}
	
	public List<String> selectDistinctSi() {
		return koreaSiGuDongDAO.selectDistinctSi();
	}
}

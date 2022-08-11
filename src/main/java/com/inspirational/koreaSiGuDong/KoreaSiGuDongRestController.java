package com.inspirational.koreaSiGuDong;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/korea_sigudong")
@RestController
public class KoreaSiGuDongRestController {
	@Autowired
	private KoreaSiGuDongBO koreaSiGuDongBO;
	
	@RequestMapping("/all")
	public Map<String, Object> getAll() {
		Map<String, Object> map = new HashMap<>();
		List<String> listDistinctSi = koreaSiGuDongBO.selectDistinctSi();
		List<KoreaSiGuDong> listKoreaSiGuDong = koreaSiGuDongBO.selectAll();
		map.put("list_korea_si_gu_dong", listKoreaSiGuDong);
		return map;
	}
	
	@RequestMapping("/si")
	public Map<String, Object> getSi() {
		Map<String, Object> map = new HashMap<>();
		List<String> listDistinctSi = koreaSiGuDongBO.selectDistinctSi();
		map.put("list_distinct_si", listDistinctSi);
		return map;
	}
	
	@RequestMapping("/gu")
	public Map<String, Object> getGu(
			@RequestParam("si") String si) {
		Map<String, Object> map = new HashMap<>();
		List<String> listDistinctGu = koreaSiGuDongBO.selectDistinctGuwhereSi(si);
		map.put("list_distinct_gu", listDistinctGu);
		return map;
	}
	
	@RequestMapping("/dong")
	public Map<String, Object> getDong(
			@RequestParam("si") String si,
			@RequestParam("gu") String gu) {
		Map<String, Object> map = new HashMap<>();
		List<String> listDistinctDong = koreaSiGuDongBO.selectDistinctDongwhereSiAndGu(si, gu);
		map.put("list_distinct_dong", listDistinctDong);
		return map;
	}
}

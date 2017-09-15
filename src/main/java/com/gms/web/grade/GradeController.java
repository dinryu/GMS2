package com.gms.web.grade;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/grade")
public class GradeController {
	private static final Logger logger = LoggerFactory.getLogger(GradeController.class);
	@RequestMapping("/grade_add") 
	public String gAdd() {
		logger.info("grade_add 진입");
		return "auth:grade/grade_add.tiles";
	}
	/*
	@RequestMapping("/grade_list") 
	public String gList() {
		logger.info("grade_list 진입");
		return "auth:grade/grade_list.tiles";
	}
	
	@RequestMapping("/grade_detail") 
	public String gDetail() {
		logger.info("grade_detail 진입");
		return "auth:grade/grade_detail.tiles";
	}
	
	@RequestMapping("/grade_delete") 
	public String bDelete() {
		logger.info("grade_delete 진입");
		return "auth:grade/grade_delete.tiles";
	}
*/
}

package com.gms.web.greade;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gms.web.member.MemberController;

@Controller
@RequestMapping("/grade")
public class GreadeController {
	private static final Logger logger = LoggerFactory.getLogger(GreadeController.class);
	@RequestMapping("/gAdd") 
	public String gAdd() {
		logger.info("gadd 진입");
		return "greade/grade_add";
	}
	
	@RequestMapping("/glist") 
	public String gList() {
		logger.info("glist 진입");
		return "greade/grade_list";
	}
	
	@RequestMapping("/gdetail") 
	public String gDetail() {
		logger.info("gdetail 진입");
		return "greade/grade_detail";
	}
	
	@RequestMapping("/gdelete") 
	public String bDelete() {
		logger.info("gdelete 진입");
		return "greade/grade_delete";
	}

}

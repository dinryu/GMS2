package com.gms.web.member;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/member") 
public class MemberController {
    private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@RequestMapping("/mAdd") 
	public String mAdd() {
		logger.info("madd 진입");
		return "member/member_add";
	}
	
	@RequestMapping("/mlist") 
	public String mList() {
		logger.info("mlist 진입");
		return "member/member_list";
	}
	
	@RequestMapping("/mdetail") 
	public String mDetail() {
		logger.info("mdetail 진입");
		return "member/member_detail";
	}
	
	@RequestMapping("/mdelete") 
	public String mDelete() {
		logger.info("mdelete 진입");
		return "member/member_delete";
	}


}

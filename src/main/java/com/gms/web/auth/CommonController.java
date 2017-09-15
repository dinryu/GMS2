package com.gms.web.auth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gms.web.command.CommandDTO;
import com.gms.web.member.MemberDTO;
import com.gms.web.member.MemberService;

@Controller
@RequestMapping("/common")
public class CommonController {
	private static final Logger logger = LoggerFactory.getLogger(CommonController.class);;
	@Autowired MemberDTO member;
	@Autowired CommandDTO cmd;
	
	@RequestMapping("/path/{dir}/{page}")
	public String move(@PathVariable String dir,
			           @PathVariable String page) {
		logger.info("CommonController :{} ","enter");
		return String.format("auth:%s/%s.tiles", dir,page);
	}

}

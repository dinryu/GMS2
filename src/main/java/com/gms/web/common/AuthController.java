package com.gms.web.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth") //아래 컨트롤러 결정
public class AuthController {
	private static final Logger logger = LoggerFactory.getLogger(AuthController.class);
	
	@RequestMapping("/login_view") //return 경로 결정
	public String goLogin() {
		logger.info("login 진입");
		return "public:common/login.tiles";
	}
	
	@RequestMapping("/login") 
	public String login() {
		logger.info("login 진입");

		return "common/main";
	}

}

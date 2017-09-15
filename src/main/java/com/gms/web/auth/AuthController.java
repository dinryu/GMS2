package com.gms.web.auth;

import java.util.Map;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.gms.web.command.CommandDTO;
import com.gms.web.member.MemberDTO;
import com.gms.web.member.MemberService;

@Controller 
@SessionAttributes("user")
@RequestMapping("/auth") //아래 컨트롤러 결정
public class AuthController {
	private static final Logger logger = LoggerFactory.getLogger(AuthController.class);
	@Autowired MemberService service;
	@Autowired MemberDTO member;
	@Autowired CommandDTO cmd;
	
	@RequestMapping("/login_view") //return 경로 결정
	public String goLogin() {
		logger.info("login 진입");
		return "public:common/login.tiles";
	}
		
	@RequestMapping(value="/login",method=RequestMethod.POST) 
	public String login(@RequestParam("id") String id,@RequestParam("pass") String pass,Model model) { 
		
		logger.info("login id : "+id);
		cmd.setSearch(id);
		cmd.setColumn(pass);		
		Map<String, Object> map = service.login(cmd);
		if(map.get("message").equals("성공")) {
			model.addAttribute("user", map.get("user"));
		}
		model.addAttribute("message", map.get("message"));		
		return String.valueOf(map.get("page"));
		/*return "auth:common/main.tiles";*/
	}

}

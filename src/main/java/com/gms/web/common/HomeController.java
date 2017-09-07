package com.gms.web.common;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/")
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

//		String now =new SimpleDateFormat("yyyy년 MM월 dd일 a hh:mm:ss").format(new Date());
//		model.addAttribute("serverTime", now);	
		model.addAttribute("serverTime", new SimpleDateFormat("yyyy년 MM월 dd일 a hh:mm:ss").format(new Date()) );
		
		return "public:common/home.tiles";
	}
	
}

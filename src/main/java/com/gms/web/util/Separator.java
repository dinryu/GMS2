package com.gms.web.util;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.gms.web.command.CommandDTO;
import com.gms.web.complex.CommandFactory;

@Component
public class Separator {
	public static CommandDTO cmd=new CommandDTO();	
	public static void init(HttpServletRequest request){
		String servletPath=request.getServletPath();
/*		String action=request.getParameter("action");
		String page=request.getParameter("page");		
		String dir=servletPath.substring(1,servletPath.indexOf("."));		
		cmd=CommandFactory.createCommand(dir,action,page);	
*/	
		
		cmd=CommandFactory.createCommand(
			servletPath.substring(1,servletPath.indexOf(".")),
			request.getParameter("action"),			
			request.getParameter("page"),
			request.getParameter("pageNumber"),
			request.getParameter("column"),
			request.getParameter("search"));
		System.out.println("Separator init : "+cmd);
	}
}

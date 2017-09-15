package com.gms.web.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.gms.web.command.CommandDTO;
import com.gms.web.complex.PathFactory;
import com.gms.web.grade.MajorDTO;
import com.gms.web.proxy.PageProxy;

@Controller
@SessionAttributes("student")
@RequestMapping({"/member","/student"}) 
public class MemberController {
    private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	@Autowired MemberService service;
	@Autowired CommandDTO cmd;
	@Autowired PageProxy pxy;
	@Autowired MemberDTO member;
	@Autowired MajorDTO major;
	
	@RequestMapping(value="/minsert",method=RequestMethod.POST)
	public String mInsert(@ModelAttribute MemberDTO member,@RequestParam("subject") List<String> list) {
		
		logger.info("등록 id : {}",member.getId());
		logger.info("등록 name : {}",member.getName());
		logger.info("등록 pass : {}",member.getPass());
		logger.info("등록 email : {}",member.getEmail());
		logger.info("등록 phone : {}",member.getPhone());
		System.out.println("등록과목 :"+list);
		
		Map<String,Object> paramMap = new HashMap<>();
		paramMap.put("mamber", member);
		List<MajorDTO> paramList=new ArrayList<>();
	
		MajorDTO mj=null;
		for(String m:list) {
			mj=new MajorDTO();
			mj.setId(member.getId());
			mj.setMajorId("Math.random");
			mj.setSubjId(m);
			mj.setTitle(m);
			paramList.add(mj);
		}
        paramMap.put("list", paramList);
		service.add(paramMap);
		logger.info("service.add(paramMap) : {}",service.add(paramMap));
		return "";
	}
	@RequestMapping("/mlist/{pageNumber}")
	@SuppressWarnings("unchecked")
	public String mList(Model model,@PathVariable int pageNumber) {
		logger.info("mlist 진입");
		pxy.setPageSize(5);
		pxy.setBlockSize(5);
		pxy.setPageNumber(pageNumber);
		int count = Integer.parseInt(service.count());
		pxy.setTheNumberOfRows(count);
		int[] result = new int[6];
		int theNumberOfPages = 0, startPage=0,endPage=0;
		theNumberOfPages = (pxy.getTheNumberOfRows() % pxy.getPageSize()) == 0? pxy.getTheNumberOfRows()/pxy.getPageSize():pxy.getTheNumberOfRows()/pxy.getBlockSize()+1;
		startPage = pxy.getPageNumber() - ((pxy.getPageNumber() - 1)%(pxy.getBlockSize()));
		endPage = (startPage + pxy.getBlockSize() -1 <= theNumberOfPages) ? startPage + pxy.getBlockSize() -1 : theNumberOfPages;
		result[0] = pxy.getPageNumber();
		result[1] = theNumberOfPages;
		result[2] = startPage;
		result[3] = endPage;
		result[4] = (startPage - (theNumberOfPages/pxy.getBlockSize())>0)?1:0;
		result[5] = startPage + pxy.getBlockSize();
		if(pxy.getPageNumber() <= pxy.getBlockSize()
				/ pxy.getPageNumber() + 1) {
			if(pxy.getPageNumber()==1) {
				cmd.setStartRow("1");
				cmd.setEndRow(String.valueOf(pxy.getPageSize()));
			}
		}else {
			cmd.setStartRow(String.valueOf((pxy.getPageNumber()-1)*pxy.getPageSize() +1));
			cmd.setEndRow(String.valueOf(pxy.getPageNumber() * pxy.getBlockSize()));
		}
		
		List<StudentDTO> list =(List<StudentDTO>)service.list(cmd);
		pxy.execute(model, result, list);
		logger.info("MemberController mlist 결과 : "+list);
		model.addAttribute("count",service.count());
		logger.info("MemberController mlist service.count 결과 : "+service.count());
		model.addAttribute("list",list);
		logger.info("MemberController return 전");
		return "auth:member/member_list.tiles";
	}
	
	@RequestMapping("/mdetail/{id}") 
	public String mDetail(Model model,@PathVariable String id) {
		logger.info("mDetail 진입");		
	    cmd.setSearch(id);
	    model.addAttribute("search", cmd.getSearch());
	    model.addAttribute("student", service.findById(cmd));
		return "auth:member/member_detail.tiles";
	}
	@RequestMapping("/mupdate") 
	public String mUpdate(@ModelAttribute MemberDTO member) {
		logger.info("mupdate 진입");	
	    service.modify(member);	
		return "auth:member/member_list.tiles";
	}
	
	@RequestMapping("/mdelete/{id}") 
	public String mDelete(Model model,@PathVariable String id) {
		logger.info("mDelete 진입");		
	    cmd.setSearch(id);
		service.remove(cmd);
		return "redirect:/member/mlist/1";
	}


}

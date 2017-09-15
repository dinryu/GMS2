package com.gms.web.member;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gms.web.command.CommandDTO;
import com.gms.web.grade.GradeDTO;
import com.gms.web.grade.MajorDTO;
import com.gms.web.grade.SubjectDTO;
import com.gms.web.mapper.GradeMapper;
import com.gms.web.mapper.MemberMapper;


@Service
public class MemberServiceImpl implements MemberService {
	private static final Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);
	@Autowired MemberMapper mapper; // new mapper 와 동일
	@Autowired MemberDTO member;
	@Autowired CommandDTO cmd;
	@Autowired GradeMapper gMapper;
	@Autowired MajorDTO major;
	
	@Override @Transactional
	public int add(Map<?,?> map) {
		member=(MemberDTO)map.get("member");
		@SuppressWarnings("unchecked")
		List<MajorDTO> list =(List<MajorDTO>) map.get("list");
		major=(MajorDTO)map.get("major");
		mapper.insert(member);
		gMapper.insertMajor(major);

		int rs =0;
	
		return rs;
	}
	
	@Override
	public List<?> list(CommandDTO cmd) {
		System.out.println("public List<?> list(CommandDTO cmd) :"+mapper.selectAll(cmd));
		return mapper.selectAll(cmd);
	}
	@Override
	public String count() {
		logger.info("count is {}", "enter");
		String count =mapper.count();
		logger.info("count is {}", "out");
		return count;
	}
	@Override
	public List<?> findByNames(CommandDTO cmd) {

		return null;
	}
	@Override
	public StudentDTO findById(CommandDTO cmd) {
		return mapper.selectById(cmd);
	}
	@Override
	public int modify(MemberDTO member) {
		System.out.println("public String modify(MemberDTO member) :"+mapper.update(member));
		return mapper.update(member);	
	}
	@Override
	public int remove(CommandDTO cmd) {
		System.out.println("public String remove(CommandDTO cmd) :"+mapper.delete(cmd));
		return mapper.delete(cmd);		
	}
	@Override
	public  Map<String, Object> login(CommandDTO cmd) {
		Map<String, Object> map = new HashMap<>();
		member = mapper.login(cmd);
		String page ="";
		String message ="";
		if(member !=null) {
			 if(cmd.getColumn().equals(member.getPass())){
				 message = "성공";
			    page =  "auth:common/main.tiles";
		    }
		    else {
		    	message = "비번 없음";
			    page =  "public:common/login.tiles";
		    } 
		} else {
			message = "아이디 없음";
			page =  "public:common/join.tiles";
		}
		
		/*
		MemberDTO cmd = new MemberDTO();
		cmd.setId(bean.getSearch());		
		String page =(cmd !=null)?(bean.getPw().equals(bean.getPw()))? "main":"login_fail":"join";	
		*/	
		
		map.put("message", message);
		map.put("page",page);
		map.put("user", member);
		return map;
	}
}
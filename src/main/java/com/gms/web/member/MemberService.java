package com.gms.web.member;

import java.util.*;

import org.springframework.stereotype.Component;
import com.gms.web.command.CommandDTO;

@Component
public interface MemberService {
	public String add(Map<String,Object> map);
	public List<?> list(CommandDTO cmd);
	public List<?> findByNames(CommandDTO cmd);
	public StudentDTO findById(CommandDTO cmd);
	public String countMembers(CommandDTO cmd);
	public String modify(MemberDTO member);
	public String remove(CommandDTO cmd);
    public Map<String, Object> login(MemberDTO bean);	
    //MemberBean[] list=new MemberBean[4];
}
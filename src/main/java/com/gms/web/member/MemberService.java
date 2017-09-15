package com.gms.web.member;

import java.util.*;

import org.springframework.stereotype.Component;
import com.gms.web.command.CommandDTO;

@Component
public interface MemberService {
	public int add(Map<?,?> map);
	public List<?> list(CommandDTO cmd);
	public List<?> findByNames(CommandDTO cmd);
	public StudentDTO findById(CommandDTO cmd);
	public String count();
	public int modify(MemberDTO member);
	public int remove(CommandDTO cmd);
    public Map<String, Object> login(CommandDTO cmd);	
    //MemberBean[] list=new MemberBean[4];
}
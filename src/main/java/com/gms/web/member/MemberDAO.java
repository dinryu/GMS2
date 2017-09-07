package com.gms.web.member;

import java.util.List;import java.util.Map;

import org.springframework.stereotype.Repository;

import com.gms.web.command.CommandDTO;

@Repository
public interface MemberDAO {
	
	public String insert(Map<?,?> map);
	public List<?> selectAll(CommandDTO cmd);
	public String countMembers(CommandDTO cmd);
	public StudentDTO selectById(CommandDTO cmd);
	public List<?> selectByNames(CommandDTO cmd);
	public String update(MemberDTO member);
	public String delete(CommandDTO cmd);
	//MemberBean[] list=new MemberBean[4];
}
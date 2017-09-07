package com.gms.web.member;

import java.util.*;

import org.springframework.stereotype.Service;

import com.gms.web.command.CommandDTO;
import com.gms.web.greade.MajorDTO;

@Service
public class MemberServiceImpl implements MemberService {
	public static MemberServiceImpl getInstance() {
		return new MemberServiceImpl();
		}
	public MemberServiceImpl() {}
	@Override
	public String add(Map<String,Object> map) {
		System.out.println("MemberServiceimpl ����");
		MemberDTO m=(MemberDTO)map.get("member");
		System.out.println("�Ѿ�� ȸ�� �̸�:"+m.getName());
		@SuppressWarnings("unchecked")
		List<MajorDTO> list = (List<MajorDTO>)map.get("major");
		System.out.println("�Ѿ�� ���� ����"+list);
//		MemberDAOImpl.getInstance().insert(map);
		return null;
	}
	@Override
	public List<?> list(CommandDTO cmd) {
		return null;
	}
	@Override
	public String countMembers(CommandDTO cmd) {
		return String.valueOf(null);
	}
	@Override
	public List<?> findByNames(CommandDTO cmd) {
		System.out.println("findByNames : "+cmd.getSearch());
		return null;
	}
	@Override
	public StudentDTO findById(CommandDTO cmd) {
		return null;
	}
	@Override
	public String modify(MemberDTO param) {
		String msg="";
		return msg;	
	}
	@Override
	public String remove(CommandDTO cmd) {
		String msg="";
		return msg;		
	}
	@Override
	public  Map<String, Object> login(MemberDTO bean) {
		Map<String, Object> map = new HashMap<>();
		CommandDTO cmd = new CommandDTO();
		cmd.setSearch(bean.getId());
		StudentDTO m = null;
		String page =(m !=null)?(bean.getPw().equals(bean.getPw()))? "main":"login_fail":"join";					
		map.put("page",page);
		map.put("user", m);
		return map;
	}
}
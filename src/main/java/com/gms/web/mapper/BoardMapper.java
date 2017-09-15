package com.gms.web.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.gms.web.board.BoardDTO;
import com.gms.web.member.MemberDTO;

@Repository
public interface BoardMapper {
	public String insert(MemberDTO member);
	public String count();
	public List<BoardDTO> selectAll();
	public List<BoardDTO> selectById(String id);
	public BoardDTO selectBySeq(int seq);
	public String update(BoardDTO bean);
	public String delete(int seq);	
}

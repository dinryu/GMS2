package com.gms.web.board;

import java.util.List;

import org.springframework.stereotype.Component;


@Component
public interface BoardService {
	public String write(BoardDTO bean);
	public String count();
	public List<BoardDTO> list();
	public List<BoardDTO> findById(String id);
	public BoardDTO findBySeq(int seq);
	public String modify(BoardDTO bean);
	public String remove(int seq);	
}

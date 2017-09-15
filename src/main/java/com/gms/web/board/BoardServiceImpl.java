package com.gms.web.board;


import java.util.List;

import org.springframework.stereotype.Service;


@Service
public class BoardServiceImpl implements BoardService {
	public static BoardServiceImpl getInstance() {
		return new BoardServiceImpl();
	}
	private BoardServiceImpl() {}

	@Override
	public String write(BoardDTO bean) {
		return null;
	}

	@Override
	public String count() {
		return null;
	}

	@Override
	public List<BoardDTO> list() {
		return null;
	}

	@Override
	public List<BoardDTO> findById(String id) {
		return null;
	}

	@Override
	public BoardDTO findBySeq(int seq) {
		return null;
	}

	@Override
	public String modify(BoardDTO bean) {
		return null;
	}

	@Override
	public String remove(int seq) {
		return null;
	}

}
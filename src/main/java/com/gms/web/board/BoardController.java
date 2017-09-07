package com.gms.web.board;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gms.web.greade.GreadeController;

@Controller
@RequestMapping("/board") //아래 컨트롤러 결정
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	@RequestMapping("/bwrite") 
	public String bWrite() {
		logger.info("bwrite 진입");
		return "board/board_write";
	}
	
	@RequestMapping("/blist") 
	public String bList() {
		logger.info("blist 진입");
		return "board/board_list";
	}
	
	@RequestMapping("/bdetail") 
	public String bDetail() {
		logger.info("bdetail 진입");
		return "board/board_detail";
	}
	
	@RequestMapping("/bdelete") 
	public String bDelete() {
		logger.info("bdelete 진입");
		return "board/board_delete";
	}


}

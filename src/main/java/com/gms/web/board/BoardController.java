package com.gms.web.board;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gms.web.grade.GradeController;

@Controller
@RequestMapping("/board") //아래 컨트롤러 결정
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	@RequestMapping("/board_write") 
	public String bWrite() {
		logger.info("board_write 진입");
		return "auth:board/board_write.tiles";
	}
	/*
	@RequestMapping("/board_list") 
	public String bList() {
		logger.info("board_list 진입");
		return "auth:board/board_list.tiles";
	}
	
	@RequestMapping("/board_detail") 
	public String bDetail() {
		logger.info("board_detail 진입");
		return "auth:board/board_detail.tiles";
	}
	
	@RequestMapping("/board_delete") 
	public String bDelete() {
		logger.info("board_delete 진입");
		return "auth:board/board_delete.tiles";
	}
*/

}

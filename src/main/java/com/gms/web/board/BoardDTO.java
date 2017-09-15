package com.gms.web.board;

import java.io.Serializable;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.gms.web.command.CommandDTO;

import lombok.Data;

@Data @Lazy @Component
public class BoardDTO {
	private String id, title, content, regdate;
	private int seq, hitcount;
			
}
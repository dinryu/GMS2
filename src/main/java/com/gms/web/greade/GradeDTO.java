package com.gms.web.greade;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.gms.web.command.CommandDTO;

import lombok.Data;

@Data @Lazy @Component
public class GradeDTO {

	    private String grade_seq,  score, exam_date, subj_id, member_id; 
}

package com.gms.web.member;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.gms.web.board.ArticleDTO;

import lombok.Data;
@Data @Lazy @Component
public class StudentDTO {
    private String num,id,name,ssn,regdate,phone,email,subjects;
}

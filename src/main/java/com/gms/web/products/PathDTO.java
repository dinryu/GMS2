package com.gms.web.products;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.gms.web.grade.GradeDTO;

import lombok.Data;
//@Lazy(게으름) : 필료할때 움직인다.(즉 PathDTO가 필요할때...)
//@Component(부품) 
@Data @Lazy @Component
public class PathDTO {
	private String ctx,img,js,css;

}

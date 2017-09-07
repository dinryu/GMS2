package com.gms.web.greade;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data @Lazy @Component
public class MajorDTO {
	
	private String majorId, title, id, subjId;
	
}

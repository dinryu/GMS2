package com.gms.web.member;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.gms.web.board.BoardDTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data @Lazy @Component
public class MemberDTO {
    @Getter @Setter
    private String id, pass, name,phone,ssn,email,profile,birthday,gender,major,regdate;

	@Override
	public String toString() {
		return "MemberBean [id=" + id + ", pass=" + pass + ", name=" + name + ", phone=" + phone + ", ssn=" + ssn
				+ ", email=" + email + ", profile=" + profile + ", birthday=" + birthday + ", gender=" + gender
				+ ", major=" + major + ", regdate=" + regdate + "]";
	}  

}
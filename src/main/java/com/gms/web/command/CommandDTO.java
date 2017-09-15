package com.gms.web.command;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.gms.web.constant.*;
import com.gms.web.member.MemberDTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data @Lazy @Component
public class CommandDTO implements Commandable {

    protected String action,pageNumber,view,column,search,dir,startRow,endRow,page;
    protected MemberDTO member;
	
	public void setPageNumber(String pageNumber){
		this.pageNumber=(pageNumber==null )?"1":pageNumber;				
		System.out.println("Command pageNumber :"+this.pageNumber);		
	}
	
	public void setAction(String action){
		this.action=(action==null)?"move":action;				
			System.out.println("Command action :"+this.action);
	}
	
	@Override
	public void process() {
		this.view=(dir.equals("home"))?"/WEB-INF/view/common/home.jsp":				
				Path.VIEW+dir+Path.SEPARATOR+page+Extension.JSP;
		System.out.println("Command process view page :"+page);
		System.out.println("Command process view :"+view);
	}

	@Override
	public String toString() {
		return "Command =[ " + dir +"/"+page+".jsp"+ ", Action=" + action +  " ]";
	}

	public void setColumn(String column) {
		this.column = (column==null)?"none":column;
		System.out.println("Command column :"+this.column);
	}

	public void setSearch(String search) {
		this.search = (search==null)?"none":search;
	}	
	
}

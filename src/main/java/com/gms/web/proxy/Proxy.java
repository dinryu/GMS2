package com.gms.web.proxy;


import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;
import lombok.Getter;

@Component
public abstract class Proxy {

	HttpServletRequest request;
	public HttpServletRequest getRequest() {
		return request;
	}
	public Proxy(HttpServletRequest request){
		this.request=request;
	}
}

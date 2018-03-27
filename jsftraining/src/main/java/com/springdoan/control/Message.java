package com.springdoan.control;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name="message", eager = true)
@RequestScoped
public class Message {
	private String message = "Hello world spring12 !";

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}

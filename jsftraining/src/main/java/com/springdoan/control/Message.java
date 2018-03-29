package com.springdoan.control;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name="message", eager = true)
@RequestScoped
public class Message {
	private String message = "Training JSF!";

	public String getMessage() {
		return message;
	}
	
}

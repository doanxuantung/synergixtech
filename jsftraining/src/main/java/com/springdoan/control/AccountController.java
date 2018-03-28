package com.springdoan.control;

import java.util.*;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import com.springdoan.model.*;

@ManagedBean(name = "accountController", eager = true)
@SessionScoped
public class AccountController {
	
	
	private Account acc;
	
	public Account getAcc() {
		return acc;
	}

	public void setAcc(Account acc) {
		this.acc = acc;
	}

	public List<Account> getListAccount() {
		List<Account> lstAcc = new ArrayList<Account>();
		lstAcc.add(new Account(1, "Spring", "Spring123", "Male"));
		lstAcc.add(new Account(2, "Polo", "Polo123", "Famale"));
		return lstAcc;
	}
	
	public String addAccount() {
		System.out.println(acc.getUsername());
		return null;
	}
	
	
}

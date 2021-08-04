package com.techaspect.atm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.techaspect.atm.dao.DBconnection;
import com.techaspect.atm.to.User;

@Component
public class atmService {
	DBconnection dbconnection ;

	@Autowired
	public atmService(DBconnection dbconnection) {
		System.out.println("atmservice");
		this.dbconnection = dbconnection;
	}
	
	
	User user1= new User();

	public boolean CheckCredentials(User user) {
		this.user1 = user;
		boolean status   = dbconnection.LoginUser(user);
		
		return status;
		
	}


	public User Withdraw(String amt, User user) {
		
		boolean status = dbconnection.Withdraw(amt , user);
		return user;
	}


	public User BalanceEnquiry(User user) {
		this.user1 = user;
		boolean status = dbconnection.BalanceEnquiry(user);
		return user;
		
		
	}


	public User MiniStatement(User user) {
		this.user1 = user;
		boolean status =	dbconnection.MiniStatement(user);
		return user;
			
	}
	

}

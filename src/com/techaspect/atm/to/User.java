package com.techaspect.atm.to;

import org.springframework.stereotype.Controller;


public class User {
	private String uid;
	private String fname;
	private String lname;
	private String pin;
	private String accno;
	private String accbal;
	private String acctype;
	private String transaction;
	private String password;
	private String cust_id;
	
	public User() {
		
	}

	public User(String uid, String fname, String lname, String pin, String accno, String accbal, String acctype,
			String transaction) {
		super();
		this.uid = uid;
		this.fname = fname;
		this.lname = lname;
		this.pin = pin;
		this.accno = accno;
		this.accbal = accbal;
		this.acctype = acctype;
		this.transaction = transaction;
	}

	public String getUid() {
		return uid;
	}

	public User(String uid, String fname, String lname, String pin, String accno, String accbal, String acctype,
			String transaction, String password, String cust_id) {
		super();
		this.uid = uid;
		this.fname = fname;
		this.lname = lname;
		this.pin = pin;
		this.accno = accno;
		this.accbal = accbal;
		this.acctype = acctype;
		this.transaction = transaction;
		this.password = password;
		this.cust_id = cust_id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public String getAccno() {
		return accno;
	}

	public void setAccno(String accno) {
		this.accno = accno;
	}

	public String getAccbal() {
		return accbal;
	}

	public void setAccbal(String accbal) {
		this.accbal = accbal;
	}

	public String getAcctype() {
		return acctype;
	}

	public void setAcctype(String acctype) {
		this.acctype = acctype;
	}

	public String getTransaction() {
		return transaction;
	}

	public void setTransaction(String transaction) {
		this.transaction = transaction;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCust_id() {
		return cust_id;
	}

	public void setCust_id(String cust_id) {
		this.cust_id = cust_id;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}


	
}

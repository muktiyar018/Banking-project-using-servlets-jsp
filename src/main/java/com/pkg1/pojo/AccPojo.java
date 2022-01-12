package com.pkg1.pojo;

import java.sql.Connection;

import com.pkg1.db.DbConnection;

import lombok.Data;

@Data
public class AccPojo {

	String accno;
	String acctype;
	String cust_name;
	double balance;
	public AccPojo(String accno, String acctype, String cust_name, double balance) {
		super();
		this.accno = accno;
		this.acctype = acctype;
		this.cust_name = cust_name;
		this.balance = balance;
	}
	
	
}

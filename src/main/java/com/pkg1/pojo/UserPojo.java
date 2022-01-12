package com.pkg1.pojo;

import lombok.Data;

@Data
public class UserPojo {

	private String uid;
	private String uname;
	private String dob;
	private String email;
	private String pass;
	public UserPojo(String uid, String uname, String dob, String email, String pass) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.dob = dob;
		this.email = email;
		this.pass = pass;
	}
public UserPojo(String uid) {
	this.uid=uid;
}

	
}

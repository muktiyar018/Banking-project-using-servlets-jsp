package com.pkg1.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.pkg1.pojo.UserPojo;


public class DbOperation {
public static boolean flag=false;
	public static void checkLogin(String uid,String upass) {
		Connection conn=DbConnection.getConnection();
		try {
			PreparedStatement st1=conn.prepareStatement("SELECT custid,custpass from userlogin where custid=? and custpass=?");
			st1.setString(1, uid);
			st1.setString(2, upass);
			ResultSet rs=st1.executeQuery();
			
			if(rs.next()) {
				if(rs.getString("custid").equals(uid)) {
//					if(rs.next()) {
						if(rs.getString("custpass").equals(upass))
						{
							flag=true;
						
					}
							
				}
	}
			conn.close();
}catch(SQLException ob3) {
	flag=false;
}
	}
public static void addtoDB(UserPojo user) {
	  	
  		Connection conn=DbConnection.getConnection();
  		try {
			PreparedStatement st=conn.prepareStatement("INSERT INTO custdetails values(?,?,?,?)");

			st.setString(1, user.getUid());
			st.setString(2, user.getUname());
			st.setString(3, user.getDob());
			st.setString(4, user.getEmail());
			st.execute();
			PreparedStatement st1=conn.prepareStatement("INSERT INTO userlogin values(?,?)");
			st1.setString(1, user.getUid());
			st1.setString(2, user.getPass());
			st1.execute();
			flag=true;
		conn.close();
    	}catch(SQLException ob3) {
    		flag=false;
    		System.out.println(ob3);
		}
}

public static void checkadminLogin(String aid,String apass) {
	Connection conn=DbConnection.getConnection();
	try {
		PreparedStatement st1=conn.prepareStatement("SELECT adminid,adminpass from adminlogin where adminid=? and adminpass=?");
		st1.setString(1, aid);
		st1.setString(2, apass);
		ResultSet rs=st1.executeQuery();
		
		if(rs.next()) {
			if(rs.getString("adminid").equals(aid)) {
//				if(rs.next()) {
					if(rs.getString("adminpass").equals(apass))
					{
						flag=true;
					
				}
						
			}
}
		conn.close();
}catch(SQLException ob3) {
flag=false;
}
}
}


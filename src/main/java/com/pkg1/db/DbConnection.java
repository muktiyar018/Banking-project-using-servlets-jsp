package com.pkg1.db;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletResponse;

public class DbConnection {

	public static boolean flag=false;
	//DataBase Connection------------------------------
	public static Connection getConnection() {
		Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		}
		catch(ClassNotFoundException exob1){
			System.out.println("Cannot load driver");
		}
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/banking1","root","password");
			
		}catch(SQLException exob2) {
			System.out.println("Cannot establish connection");
		}
		return con;
	}
	//Add to DB-------------------------------------------------
	public static void addtoDB(String accn,String custid,String acctyp,double bal) {
	  	
	  		Connection conn=getConnection();
	  		try {
				PreparedStatement st=conn.prepareStatement("INSERT INTO customers values(?,?,?,?)");

				st.setString(1, accn);
				st.setString(2, custid);
				st.setString(3, acctyp);
				st.setDouble(4, bal);
				st.execute();
				flag=true;
			conn.close();
	    	}catch(SQLException ob3) {
	    		flag=false;
			}
}
	//update (deposit) to DB------------------------------------------------
	public static void depositDB(String accn,double bal) { 
		Connection conn=getConnection();
		try {
			PreparedStatement st1=conn.prepareStatement("SELECT accno from customers where accno=?");
			st1.setString(1, accn);
			st1.execute();
			ResultSet rs=st1.executeQuery();
			
			if(rs.next()) {
				if(rs.getString("accno").equals(accn)) {flag=true;
			PreparedStatement st=conn.prepareStatement("UPDATE customers SET balance=balance+? WHERE accno=?");
			st.setDouble(1, bal);
			st.setString(2, accn);
			st.execute();	
	}
	}
			conn.close();	
			}catch(Exception ob3) {
				flag=false;	
			}
		}
	//update (Withdraw) to DB------------------------------------------------
	public static void withdrawDB(String accn,double bal) {
		Connection conn=DbConnection.getConnection();
		try {
			PreparedStatement st1=conn.prepareStatement("SELECT accno from customers where accno=?");
			st1.setString(1, accn);
			st1.execute();
			ResultSet rs=st1.executeQuery();
			
			if(rs.next()) {
				if(rs.getString("accno").equals(accn)) {
					flag=true;
			PreparedStatement st=conn.prepareStatement("UPDATE customers SET balance=balance-? WHERE accno=?");
			st.setDouble(1, bal);
			st.setString(2, accn);
			st.execute();
			}}
			conn.close();
	}catch(Exception ob3) {
		flag=false;
	}
}
	//update (transfer) to DB------------------------------------------------
	public static void transferDB(String accfrom,String accto,double bal) {
		Connection conn=DbConnection.getConnection();
		try {
			PreparedStatement st1=conn.prepareStatement("SELECT accno from customers where accno=?");
			st1.setString(1, accfrom);
			ResultSet rs1=st1.executeQuery();
			PreparedStatement st2=conn.prepareStatement("SELECT accno from customers where accno=?");
			st2.setString(1, accto);
			ResultSet rs2=st2.executeQuery();
			if(rs1.next()) {
				if(rs1.getString("accno").equals(accfrom)) {
					if(rs2.next()) {
						if(rs2.getString("accno").equals(accto)) {
							flag=true;
							PreparedStatement sta=conn.prepareStatement("UPDATE customers SET balance=balance+? WHERE accno=?");
							sta.setDouble(1, bal);
							sta.setString(2, accto);
							sta.execute();
							PreparedStatement stb=conn.prepareStatement("UPDATE customers SET balance=balance-? WHERE accno=?");
							stb.setDouble(1, bal);
							stb.setString(2, accfrom);
							stb.execute();
							}}}}
			conn.close();
		}catch(Exception ob3) {
			flag=false;
		}
	}
	//Delete Database------------------------------------------------
	public static void deleteDB(String accn) {
		Connection conn=DbConnection.getConnection();
		try {
			PreparedStatement st1=conn.prepareStatement("SELECT accno from customers where accno=?");
			st1.setString(1, accn);
			ResultSet rs=st1.executeQuery();
			
			if(rs.next()) {
				if(rs.getString("accno").equals(accn)) {
					flag=true;
			PreparedStatement st=conn.prepareStatement("DELETE from customers WHERE accno=?");
			st.setString(1, accn);
			st.execute();
			}}
			conn.close();
		}catch(Exception ob3) {
			flag=false;
		}
	}
}

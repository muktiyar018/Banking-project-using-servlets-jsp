package com.pkg2;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pkg1.db.DbConnection;

@WebServlet("/DepositeServlet")
public class DepositeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String accn=request.getParameter("accno");
		double bal=Double.parseDouble(request.getParameter("amount"));
		PrintWriter pw=response.getWriter();
        DbConnection.depositDB(accn, bal);
        
	if(DbConnection.flag==true) {
	pw.println("<html><h3 style='text-align:center'>Deposit Successful</h3></html>");
	DbConnection.flag=false;
	RequestDispatcher rd=request.getRequestDispatcher("/usermenu.html");
	rd.include(request, response);
	}else {
		pw.println("<html><table align='center'><td><p style='color:red;border-style:groove'>"+"Account Doesn't Exists"+"</p></td></table></html>");
		RequestDispatcher rd=request.getRequestDispatcher("/deposit.html");
		rd.include(request, response);
	}
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	}

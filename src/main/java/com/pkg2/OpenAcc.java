package com.pkg2;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pkg1.db.DbConnection;
import com.pkg1.pojo.AccPojo;

@WebServlet("/OpenAcc")
public class OpenAcc extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String accn=request.getParameter("accno");
		String custid=request.getParameter("custid");
		String acctyp=request.getParameter("acctype");
		double bal=Double.parseDouble(request.getParameter("balance"));
		
		PrintWriter pw=response.getWriter();
		DbConnection.addtoDB(accn,custid,acctyp,bal);
		
		if(DbConnection.flag==true) {
			pw.println("<html><h3 style='text-align:center'>Data Inserted Successfully!</h3></html>");
		RequestDispatcher rd=request.getRequestDispatcher("/adminmenu.html");
		rd.include(request, response);
		}
		else {
			pw.println("<html><table align='center'><td><p style='color:red;border-style:groove'>"+"Duplicate Entry"+"</p></td></table></html>");
			RequestDispatcher rd=request.getRequestDispatcher("/openacc.html");
			rd.include(request, response);
		}}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		doGet(request, response);
	}

}

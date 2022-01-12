package com.pkg2;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pkg1.db.DbConnection;

@WebServlet("/TransferServlet")
public class TransferServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String accfrom=request.getParameter("accno1");
		String accto=request.getParameter("accno2");
		double bal=Double.parseDouble(request.getParameter("balance"));
		PrintWriter pw=response.getWriter();
        DbConnection.transferDB(accfrom,accto,bal);
		
		if(DbConnection.flag==true) {
							pw.println("<html><h3 style='text-align:center'>Transfer Successful</h3></html>");
							DbConnection.flag=false;
							RequestDispatcher rd=request.getRequestDispatcher("/usermenu.html");
							rd.include(request, response);		
						}
				else {
					pw.println("<html><table align='center'><td><p style='color:red;border-style:groove'>"+"Check the AccNo"+"</p></td></table></html>");
					RequestDispatcher rd=request.getRequestDispatcher("/transfer.html");
					rd.include(request, response);
				}			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

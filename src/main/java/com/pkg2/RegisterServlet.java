package com.pkg2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pkg1.db.DbOperation;
import com.pkg1.pojo.UserPojo;



/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uid=request.getParameter("uid");
		String uname=request.getParameter("uname");
		String dob=request.getParameter("dob");
		String email=request.getParameter("email");
		String pass=request.getParameter("upass");
		UserPojo user=new UserPojo(uid,uname,dob,email,pass);
		DbOperation.addtoDB(user);
		PrintWriter pw=response.getWriter();
		if(DbOperation.flag==true) {
			pw.println("<html><h3 style='text-align:center'>Registered Successfully!</h3></html>");
			//DbConnection.flag==true
		RequestDispatcher rd=request.getRequestDispatcher("/index.html");
		rd.include(request, response);
		}
		else {
			pw.println("<html><table align='center'><td><p style='color:red;border-style:groove'>"+"Duplicate Entry"+"</p></td></table></html>");
			RequestDispatcher rd=request.getRequestDispatcher("/userregister.html");
			rd.include(request, response);
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

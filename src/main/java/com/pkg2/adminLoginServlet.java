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

/**
 * Servlet implementation class adminLoginServlet
 */
@WebServlet("/adminLoginServlet")
public class adminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String aid=request.getParameter("aid");
		String apass=request.getParameter("apass");
		DbOperation.checkadminLogin(aid, apass);
PrintWriter pw=response.getWriter();
if(DbOperation.flag==true) {
	pw.println("<html><h3 style='text-align:center'>Logged In Successfully!</h3></html>");
	DbOperation.flag=false;
RequestDispatcher rd=request.getRequestDispatcher("/adminmenu.html");
rd.include(request, response);
}
else {
	pw.println("<html><table align='center'><td><p style='color:red;border-style:groove'>"+"Account Doesn't exist"+"</p></td></table></html>");
	RequestDispatcher rd=request.getRequestDispatcher("/adminlogin.html");
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

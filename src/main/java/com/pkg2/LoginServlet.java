package com.pkg2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pkg1.db.DbOperation;
import com.pkg1.pojo.UserPojo;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static String unamee;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		unamee=request.getParameter("uname");
		String upass=request.getParameter("upass");
		UserPojo user=new UserPojo(unamee);
		request.setAttribute("user", user);
		
		DbOperation.checkLogin(unamee, upass);
PrintWriter pw=response.getWriter();
		
		if(DbOperation.flag==true) {
			pw.println("<html><h3 style='text-align:center'>Logged In Successfully!</h3></html>");
			DbOperation.flag=false;
		RequestDispatcher rd=request.getRequestDispatcher("/usermenu.html");
		rd.include(request, response);
		}
		else {
			pw.println("<html><table align='center'><td><p style='color:red;border-style:groove'>"+"Account Doesn't exist"+"</p></td></table></html>");
			RequestDispatcher rd=request.getRequestDispatcher("/userlogin.html");
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

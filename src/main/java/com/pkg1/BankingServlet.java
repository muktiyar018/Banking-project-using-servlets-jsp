package com.pkg1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pkg1.db.DbConnection;

/**
 * Servlet implementation class BankingServlet
 */
@WebServlet("/BankingServlet")
public class BankingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BankingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		Connection conn=DbConnection.getConnection();
//		try {
//			PreparedStatement st=conn.prepareStatement("SELECT *from customers");
//		ResultSet rs=st.executeQuery();
//		int i=0;
//		PrintWriter pr=response.getWriter();
//
//		pr.println("<html><body bgcolor='Lightskyblue'>");
//		pr.println("<h2 style='text-align:center'> - ALL CUSTOMERS -<h2>");
//		pr.println("<font size='2'><table width='70%' align='center' border=' '>");
//		pr.println("<th>Acc No</th>"
//				+ "<th>Acc Type</th>"
//				+ "<th>Name</th>"
//				+ "<th>Balance</th>"
//				);
////		pr.println("<h1>Customer Details -"+i+"<h1>");
//		while(rs.next()) {
//			
//			
//			pr.println("<tr style='text-align:center'>");
//			pr.println("<td>"+rs.getString("accno")+"</td>");
//			pr.println("<td>"+rs.getString("acctype")+"</td>");
//			pr.println("<td>"+rs.getString("cname")+"</td>");
//			pr.println("<td>"+rs.getDouble("balance")+"</td>"+"</tr>");
//			
//		}
//		pr.println("</table></font>");
//		pr.println("<br/>\r\n"
//				+ "	<form align=\"center\" name=\"bankingform\"  action=\"index.html\" >\r\n"
//				+ "	<input type=submit  value=\"Back to Home\"></form>");
//		pr.println("</body></html>");
//		conn.close();
//		}catch(SQLException ob3) {
//			System.out.println("Got an Exception");
//			System.out.println(ob3.getMessage());
//		}
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

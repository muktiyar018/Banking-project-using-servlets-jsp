<%@ page import="java.sql.Connection" 
import="com.pkg1.db.DbConnection" 
import="java.sql.*"
import="com.pkg1.pojo.UserPojo"
import="com.pkg2.LoginServlet"
language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor='Lightskyblue'>
<%
Connection conn=DbConnection.getConnection();
try{
	String uid=LoginServlet.unamee;
	PreparedStatement st=conn.prepareStatement("SELECT c.accno,c.custid,cd.cname,c.acctype,cd.dob,cd.email,c.balance from customers c,custdetails cd where c.custid=cd.custid and c.custid=?;");
	st.setString(1,LoginServlet.unamee);
	st.execute();
	ResultSet rs=st.executeQuery();%>
	<h2 style='text-align:center'> - CUSTOMER DETAILS -</h2>
		<%if(rs.next()) { %><h3 style='text-align:center'>Customer Id :<%= rs.getString("custid")%></h3>
	<h3 style='text-align:center'>Customer Name :<%= rs.getString("cname")%></h3><%} %>
	<%

	PreparedStatement st1=conn.prepareStatement("SELECT c.accno,c.custid,cd.cname,c.acctype,cd.dob,cd.email,c.balance from customers c,custdetails cd where c.custid=cd.custid and c.custid=?;");
	st.setString(1,LoginServlet.unamee);
	st.execute();
	ResultSet rs1=st.executeQuery();%>
	<font size='2'>
	<table width='70%' align='center' border=' '	>
	<th>Account No</th>
	<th>Account type</th>
	<th>Date Of Birth</th>
	<th>Email</th>
	<th>Balance</th>
				<%while(rs1.next()) { %>
				<tr style='text-align:center'>
				<td><%= rs1.getString("accno")%></td>

				<td><%= rs1.getString("acctype")%></td>
				<td><%= rs1.getString("dob")%></td>
				<td><%= rs1.getString("email")%></td>
				<td><%= rs1.getDouble("balance")%></td>
				</tr><%} %>
				</table></font>
					<br><form align="center" name="bankingform"  action="usermenu.html" >
	<input type=submit  value="Back to Home"></form>
				
<% conn.close();
}catch(SQLException ob3){
	
}%>

</body>
</html>
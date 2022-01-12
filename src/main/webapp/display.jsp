<%@ page import="java.sql.Connection" 
import="com.pkg1.db.DbConnection" 
import="java.sql.*"
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
	PreparedStatement st=conn.prepareStatement("SELECT c.accno,c.custid,cd.cname,c.acctype,cd.dob,cd.email,c.balance from customers c,custdetails cd where c.custid=cd.custid;");
	ResultSet rs=st.executeQuery();%>
	<h2 style='text-align:center'> - ALL CUSTOMERS -</h2>
	<font size='2'>
	<table width='70%' align='center' border=' '	>
	<th>Account No</th>
	<th>Customer Id</th>
	<th>Cust Name</th>
	<th>Account type</th>
	<th>Date Of Birth</th>
	<th>Email</th>
	<th>Balance</th>
				<%while(rs.next()) { %>
				<tr style='text-align:center'>
				<td><%= rs.getString("accno")%></td>
				<td><%= rs.getString("custid")%></td>
				<td><%= rs.getString("cname")%></td>
				<td><%= rs.getString("acctype")%></td>
				<td><%= rs.getString("dob")%></td>
				<td><%= rs.getString("email")%></td>
				<td><%= rs.getDouble("balance")%></td>
				</tr><%} %>
				</table></font>
					<br><form align="center" name="bankingform"  action="adminmenu.html" >
	<input type=submit  value="Back to Home"></form>
				
<% conn.close();
}catch(SQLException ob3){
	
}%>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="java.sql.*" %>
<html>
<head>
<title>Patient Details</title>
</head>
<body>
<h2 align="center">Patient Information</h2>
<%try{
Connection conn;
Class.forName("org.postgresql.Driver");
conn = DriverManager.getConnection("jdbc:postgresql:practice_db","postgres","postgres");
Statement st = conn.createStatement();
ResultSet rs = st.executeQuery("select * from patient");
%>
<table border="1" width="40%">
<tr>
<th>Patient No</th>
<th>Name</th>
<th>Address</th>
<th>Age</th>
<th>Disease</th>
</tr>
<% while(rs.next()) { %>
<tr>
<td><%= rs.getInt("pno") %></td>
<td><%= rs.getString("pname") %></td>
<td><%= rs.getString("address") %></td>
<td><%= rs.getInt("age") %></td><td><%= rs.getString("disease") %></td>
</tr>
<% } %>
</table>
<%
conn.close();
}catch(Exception e){
out.println(e);
}
%>
</body>
</html>

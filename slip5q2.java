<%@ page import="java.sql.*,java.util.*" %>
<%

if(session.getAttribute("count") == null){
session.setAttribute("count", 0);
session.setAttribute("score", 0);
}
int count = (int)session.getAttribute("count");
int score = (int)session.getAttribute("score");

String userAns = request.getParameter("ans");
String correctAns = (String)session.getAttribute("correct");
if(userAns != null && correctAns != null){
if(userAns.equals(correctAns)){
score++;
session.setAttribute("score", score);
}
}
if(request.getParameter("submit") != null){
%>
<h2>Your Total Score : <%= score %></h2>
<%
session.invalidate();
%>
<%
return;
}

Class.forName("org.postgresql.Driver");
Connection con = DriverManager.getConnection(
"jdbc:postgresql:database_name","postgres","password");
Statement st = con.createStatement();

ResultSet rs = st.executeQuery(
"SELECT * FROM question ORDER BY random() LIMIT 1");
if(rs.next()){
session.setAttribute("correct", rs.getString("answer"));
%><html>
<body>
<h3>Online Test</h3>
<form method="post">
<p><b><%= rs.getString("question") %></b></p>
<input type="radio" name="ans" value="<%=rs.getString("opt1")%>" required>
<%= rs.getString("opt1") %><br>
<input type="radio" name="ans" value="<%=rs.getString("opt2")%>">
<%= rs.getString("opt2") %><br>
<input type="radio" name="ans" value="<%=rs.getString("opt3")%>">
<%= rs.getString("opt3") %><br>
<input type="radio" name="ans" value="<%=rs.getString("opt4")%>">
<%= rs.getString("opt4") %><br><br>
<input type="submit" value="Next">
<input type="submit" name="submit" value="Submit">
</form>
</body>
</html><%
count++;
session.setAttribute("count", count);
}
con.close();
%>

<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<html>
<head>
<title>Time Based Greeting</title>
</head>
<body>
<h2>Enter Your Name</h2>
<form method="post">
UserName: <input type="text" name="username" required>
<input type="submit" value="Greet Me">
</form>
<%
String username = request.getParameter("username");
if (username != null && !username.isEmpty()) {
java.util.Calendar cal = java.util.Calendar.getInstance();
int hour = cal.get(java.util.Calendar.HOUR_OF_DAY);
String greeting;if (hour >= 5 && hour < 12) {
greeting = "Good Morning";
} else if (hour >= 12 && hour < 17) {
greeting = "Good Afternoon";
} else if (hour >= 17 && hour < 21) {
greeting = "Good Evening";
} else {
greeting = "Good Night";
}
%>
<h3 style="color:blue;">
<%= greeting %>, <%= username %>!
</h3>
<%
}
%>
</body>
</html>

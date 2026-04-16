<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<html>
<head>
<title>Prime Number Check</title>
</head>
<body>
<h2>Prime Number Checker</h2>
<form method="post">
Enter a number:
<input type="text" name="num">
<input type="submit" value="Check">
</form>
<%String n = request.getParameter("num");
if (n != null) {
int num = Integer.parseInt(n);
boolean isPrime = true;
if (num <= 1) {
isPrime = false;
} else {
for (int i = 2; i <= num / 2; i++) {
if (num % i == 0) {
isPrime = false;
break;
}
}
}
%>
<h3 style="color:red;">
<%= (isPrime) ? num + " is a Prime Number" : num + " is NOT a Prime Number" %>
</h3>
<%
}
%></body>
</html>

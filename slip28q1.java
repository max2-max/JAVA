<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<html>
<head>
<title>Reverse String</title>
</head>
<body>
<h2>Reverse a String</h2>
<form method="post">
Enter String:
<input type="text" name="str" required>
<input type="submit" value="Reverse">
</form><%
String input = request.getParameter("str");
if (input != null) {
String reverse = "";
for (int i = input.length() - 1; i >= 0; i--) {
reverse = reverse + input.charAt(i);
}
%>
<h3>
Reversed String: <%= reverse %>
</h3>
<%
}
%>
</body>
</html>

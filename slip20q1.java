<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<html>
<head>
<title>Number to Words</title>
</head>
<body>
<h2>Enter a Number</h2>
<form method="post">
Number: <input type="text" name="num" required>
<input type="submit" value="Convert">
</form>
<%
String n = request.getParameter("num");if (n != null && !n.isEmpty()) {
String[] words = { "Zero", "One", "Two", "Three", "Four",
"Five", "Six", "Seven", "Eight", "Nine" };
out.print("<p style='color:red; font-size:18px;'>Number in words: ");
for (int i = 0; i < n.length(); i++) {
char ch = n.charAt(i);
if (Character.isDigit(ch)) {
int digit = Character.getNumericValue(ch);
out.print(words[digit] + " ");
} else {
out.print("? "); 
}
}
out.println("</p>");
}
%>
</body>
</html>

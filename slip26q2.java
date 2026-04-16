<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<html>
<head>
<title>Sum of First and Last Digit</title>
</head><body>
<h2>Enter a Number</h2>
<form method="post">
Number: <input type="text" name="num" required>
<input type="submit" value="Calculate">
</form>
<%
String numStr = request.getParameter("num");
if (numStr != null && numStr.length() > 0) {
int firstDigit = Character.getNumericValue(numStr.charAt(0));
int lastDigit = Character.getNumericValue(
numStr.charAt(numStr.length() - 1));
int sum = firstDigit + lastDigit;
%>
<p style="color:red; font-size:18px;">
Sum of first and last digit is: <%= sum %>
</p>
<%}
%>
</body>
</html>

header.jsp:
<html>
<head>
<title>Perfect Number Check</title>
</head>
<body>
<h2>Perfect Number Checker</h2>
<hr>
footer.jsp:
<hr>
</body>
</html>
perfect.jsp:
<%@ include file="header.jsp" %><form method="post">
Enter a number:
<input type="text" name="num">
<input type="submit" value="Check">
</form>
<%
String n = request.getParameter("num");
if (n != null) {
int num = Integer.parseInt(n);
int sum = 0;
for (int i = 1; i <= num / 2; i++) {
if (num % i == 0) {
sum += i;
}
}
if (sum == num) {
%>
<h3 style="color:green;"><%= num %> is a Perfect Number</h3>
<%
} else {
%><h3 style="color:red;"><%= num %> is NOT a Perfect Number</h3>
<%
}
}
%>
<%@ include file="footer.jsp" %>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>

<body>
<h1><%= "Nhập vào id của bạn!" %>
</h1>
<form action="checkUserName" method="post">
    <label>UserName</label>
    <input type="text" id="UserName" name="UserName">
    <br>
    <br>
    <label>Password</label>
    <input type="password" id="Password" name="UserPassword">
    <br>
    <br>
    <input type="submit" value="Submit">

</form>
<br/>
<%--<a href="hello-servlet">Hello Servlet</a>--%>
</body>

</html>
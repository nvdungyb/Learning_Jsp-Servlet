<%--
  Created by IntelliJ IDEA.
  User: acer
  Date: 2/18/2024
  Time: 11:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    ServletContext context = request.getServletContext();
  String userName = (String)context.getAttribute("userName");
  System.out.println(userName);
%>

<html>
<head>
    <title>Xin chào </title>
    <% if(userName != null) { %>
        <h1>Xin chào <%= userName %></h1>
    <% } else { %>
        <h1>Bạn đăng nhập không thành công.</h1>
    <% } %>

</head>
<body>

</body>
</html>

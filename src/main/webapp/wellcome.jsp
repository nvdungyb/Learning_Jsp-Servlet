        <%@ page import="model.User" %><%--
  Created by IntelliJ IDEA.
  User: acer
  Date: 2/18/2024
  Time: 11:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    User user = (User) session.getAttribute("user");
    String userName = null;
    if (user != null) {
        userName = user.getUserName();
    } else {
        response.sendRedirect("index.jsp");
    }
%>

<html>
<head>
    <title>Xin chào </title>
    <h1>Bạn <%=userName%> đã đăng nhập thành công</h1>
    <br>
    <a href="read-cookie">Chuyển hướng tới /read-cookie</a>

</head>
<body>

</body>
</html>

<%--    Sự khác nhau giữa hai thẻ <% %> và <%= %>
: Dù cả hai thẻ đều cho phép nhúng mã Java vào trong trang JSP,
nhưng thẻ <% %> chỉ cho phép nhúng mã Java mà không trả về giá trị,
còn thẻ <%= %> cho phép nhúng mã Java và trả về giá trị của biểu thức đó.

--%>
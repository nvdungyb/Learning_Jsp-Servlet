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
    String userName = (String) context.getAttribute("userName");
    String adminEmail = (String) context.getAttribute("adminEmail");
    System.out.println(userName);
%>

<html>
<head>
    <title>Xin chào </title>
    <% if (userName != null) { %>
        <h1>Xin chào <%= userName %>
        </h1>
        <br>
        <br>
        <label>Có thắc mắc xin hãy liên hệ vào email sau: </label>
        <label><%= adminEmail %></label>
    <% } else { %>
        <h1>Bạn đăng nhập không thành công.</h1>
    <% } %>

</head>
<body>

</body>
</html>

<%--    Sự khác nhau giữa hai thẻ <% %> và <%= %>
: Dù cả hai thẻ đều cho phép nhúng mã Java vào trong trang JSP,
nhưng thẻ <% %> chỉ cho phép nhúng mã Java mà không trả về giá trị,
còn thẻ <%= %> cho phép nhúng mã Java và trả về giá trị của biểu thức đó.

--%>
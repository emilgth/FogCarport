<%--
  Created by IntelliJ IDEA.
  User: karlf
  Date: 13-05-2019
  Time: 21:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@ page language="java" import="java.sql.*"%>
<%
        if(session.getAttribute("SomeAttribute")== null) {

            out.println("<script>webapp.WEB-INF.href='loggedOutIndex.jsp'</script>");
        }
            %>
</body>
</html>

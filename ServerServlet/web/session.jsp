<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/9/29
  Time: 14:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/ouzicheng/Servlet7" >
    用户名：<input type="text" name="username">
    <input type="submit" value="提交" id="button">
    <%--使用EL表达式取出session中的Token--%>
    <input type="hidden" name="token" value="${token}" >

</form>
</body>
</html>

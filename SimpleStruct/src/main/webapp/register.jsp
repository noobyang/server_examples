<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/9/23
  Time: 16:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/privilege_register" method="post">
    用户名：<input type="text" name="user.username"><br>
    密码：<input type="text" name="user.psd"><br>
    年龄：<input type="text" name="user.age"><br>
    生日：<input type="text" name="user.birthday"><br>
    <input type="submit" value="注册"><br>
</form>

</body>
</html>

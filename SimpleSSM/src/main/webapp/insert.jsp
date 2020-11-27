<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/10/26
  Time: 16:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Post</title>
</head>
<body>
    <form action="dept/insert.action" method="post">
        名称：<input type="text"   name="deptName"><br>
        地址：<input type="text" name="deptAddress"><br>
        <input type="submit" value="ok">
    </form>
</body>
</html>

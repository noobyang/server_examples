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
<form action="params5.action" method="post">
    <table align="center">
        <tr>
            <td>用户名：</td>
            <td><input type="text" name="username"></td>
        </tr>
        <tr>
            <td>出生日期</td>
            <td><input type="text" name="date" value="1996-05-24"></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="提交">
            </td>
        </tr>
    </table>

</form>
</body>
</html>

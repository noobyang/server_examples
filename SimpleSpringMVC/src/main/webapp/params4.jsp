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
<form action="params4.action" method="POST">
    <table border="2" align="center">
        <tr>
            <th>姓名</th>
            <td><input type="text" name="user.username" value="${user.username}"/></td>
        </tr>
        <tr>
            <th>月薪</th>
            <td><input type="text" name="user.id" value="${user.id}"></td>
        </tr>
        <tr>
            <th>入职时间</th>
            <td><input
                    type="text"
                    name="user.hiredate"
                    value='<fmt:formatDate value="${user.hiredate}" type="date" dateStyle="default"/>'/></td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="普通用户注册" style="width:111px"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>

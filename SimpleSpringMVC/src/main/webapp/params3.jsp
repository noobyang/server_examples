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
<form action="params3.action" method="POST">
    <table border="2" align="center">
        <caption><h2>批量注册员工</h2></caption>
        <tr>
            <td><input type="text" name="list[0].username" value="哈哈"/></td>
            <td><input type="text" name="list[0].id" value="7000"/></td>
        </tr>
        <tr>
            <td><input type="text" name="list[1].username" value="呵呵"/></td>
            <td><input type="text" name="list[1].id" value="7500"/></td>
        </tr>
        <tr>
            <td><input type="text" name="list[2].username" value="班长"/></td>
            <td><input type="text" name="list[2].id" value="8000"/></td>
        </tr>
        <tr>
            <td><input type="text" name="list[3].username" value="键状哥"/></td>
            <td><input type="text" name="list[3].id" value="8000"/></td>
        </tr>
        <tr>
            <td><input type="text" name="list[4].username" value="绿同学"/></td>
            <td><input type="text" name="list[4].id" value="9000"/></td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="批量注册"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>

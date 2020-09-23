<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>


<form action="${pageContext.request.contextPath}/LoginServlet" method="post">

    用户名：<input type="text " name="username">
    密码：<input type="password " name="psd">
    <input type="submit" value="登陆">
</form>
</body>
</html>
